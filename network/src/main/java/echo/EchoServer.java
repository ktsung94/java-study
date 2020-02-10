package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	private static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1. 서버소켓 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩 : Socket Address(IP Address + Port) Binding
			serverSocket.bind(new InetSocketAddress("127.0.0.1", PORT));
			log("Server Start...[port:" + PORT + "]");
			
			// 3. accept
			Socket socket = serverSocket.accept();	// blocking
			InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();

			InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
			String remoteHostAddress = remoteInetAddress.getHostAddress();
			int remotePort = remoteInetSocketAddress.getPort();

			log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

			try {
				// 4. IOStream 받아오기

				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); // true로 하면 자동 flush가 됨
				
				while(true) {
					// 5. 데이터 읽기
					String data = br.readLine(); // blocking
					if(data == null) {
						// client에서 정상종료
						log("closed by client");
						break;
					}

					log("received:" + data);

					// 6. 데이터 쓰기
					pw.println(data);
				}

			} catch (SocketException e) {
				log("suddenly closed by client");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if(socket != null && !socket.isClosed()) {
						socket.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void log(String log) {
		System.out.println("[server]" + log) ;
	}
}


