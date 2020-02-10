package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			//1. 키보드 연결
			scanner = new Scanner(System.in);
			//2. socket 생성
			socket = new Socket();
			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			//4. reader/writer 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true); // true로 하면 자동 flush가 됨



			//5. join 프로토콜
			System.out.print("닉네임>>" );
			String nickname = scanner.nextLine();
			printWriter.println( "join:" + nickname );
			printWriter.flush();

			//6. ChatClientReceiveThread 시작
			new ChatClientReceiveThread(socket).start();	
			//7. 키보드 입력 처리
			while( true ) {
				System.out.print( ">>" );
				String input = scanner.nextLine();

				if( "quit".equals( input ) == true ) {
					// 8. quit 프로토콜 처리
					printWriter.println("quit");
					break;
				} else {
					// 9. 메시지 처리      
					printWriter.println("message:" + input);
					printWriter.flush();
				}
			}

		} catch( IOException ex ) {
			log( "error:" + ex );
		} finally {
			if (socket != null && socket.isClosed() == false) {
				try {
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}

	public static void log(String m) {
		System.out.println("[client]" + m);
	}
}
