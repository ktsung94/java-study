package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	
	private static final int PORT = 5000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = null;
		
		try {
			serverSocket = new ServerSocket();
			listWriters = new ArrayList<Writer>();
			
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			log("연결 기다림 " + hostAddress + ":" + PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket, listWriters).start();				
	
			}

		} catch(IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void log(String m) {
		System.out.println("[server]" + m);
	}
}
