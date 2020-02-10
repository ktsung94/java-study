package chat.client;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();

		// 1. 소켓생성
		Socket socket = new Socket();
		try {
		// 2. connect to server
			socket.connect(new InetSocketAddress("localhost", 5000));
		// 3. iostream 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"), true);
		// 4. join 프로토콜 요청 및 처리
			printWriter.println("join:" + name);
		// 5. join 프로토콜이 성공 응답을 받으면
			System.out.println("join:ok");
		// 6. new ChatWindow(name, socket).show();
		new ChatWindow(name, socket).show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
