package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;

public class ChatServerThread extends Thread{

	private String nickname;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter printWriter;
	private List<Writer> listWriters;
	private Writer writer;


	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();

		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); // true로 하면 자동 flush가 됨

			while(true) {
				try {
					String request = br.readLine();
					if(request == null) {
						log("클라이언트로 부터 연결 끊김");
						break;
					}

					String[] tokens = request.split(":");
					if("join".equals(tokens[0])) {
						doJoin(tokens[1], printWriter);
					}
					else if("message".equals(tokens[0])) {
						doMessage(tokens[1]);
					}
					else if("quit".equals(tokens[0])) {
						doQuit(printWriter);
					}
					else {
						log("에러:알 수 없는 요청(" + tokens[0] + ")");
					}
				} catch (Exception e) {
					
				}

			}


		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doQuit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void removeWriter(Writer writer) {
		listWriters.remove(writer);		
	}

	private void doMessage(String string) {
		broadcast(nickname + ": " + string);

	}

	private void doJoin(String nickname, Writer writer) {
		this.nickname = nickname;

		String data = nickname + "님이 참여하였습니다.";
		broadcast(data);

		// writer pool에 저장
		addWriter(writer);

		// ack
		printWriter.println("join:ok");
		printWriter.flush();

	}
	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}

	}
	private void broadcast(String data) {
		synchronized (listWriters) {
			for(Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}

	}
	public void log(String m) {
		System.out.println("[server]" + m);
	}
}
