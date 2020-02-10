package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;
	
	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}
	
	public static void log(String log) {
		System.out.println("[server" + Thread.currentThread().getId() + "]" + log);
	}
	
	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress)socket.getRemoteSocketAddress();

		InetAddress remoteInetAddress = remoteInetSocketAddress.getAddress();
		String remoteHostAddress = remoteInetAddress.getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();

		log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

		try {
			// 4. IOStream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			while(true) {
				// 5. 데이터 읽기
				byte[] buffer = new byte[256];

				int readByteCount = is.read(buffer);	// blocking
				if(readByteCount == -1) {
					// client에서 정상종료
					log("close by client");
					break;
				}

				String data = new String(buffer, 0, readByteCount, "UTF-8");
				log("received:" + data);

				// 6. 데이터 쓰기
				os.write(data.getBytes("UTF-8"));
			}

		} catch (SocketException e) {
			log("sudden closed by client");
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
	}

}
