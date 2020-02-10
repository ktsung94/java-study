package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Localhost {

	public static void main(String[] args) {
		// InternetAddress = IP Address
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();

			String hostname = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			byte[] addresses = inetAddress.getAddress();
			System.out.println(Arrays.toString(addresses));
			
			for(byte address : addresses) {
				System.out.println(address);
			}
			
			System.out.println(hostname);
			System.out.println(hostAddress);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
