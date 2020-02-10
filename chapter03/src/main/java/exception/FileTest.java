package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileTest {

	public static void main(String[] args) {
		try {
			InputStream is = new FileInputStream("./hello.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
