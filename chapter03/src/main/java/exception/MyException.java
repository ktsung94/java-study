package exception;

public class MyException extends Exception {
	public MyException() {
		super("MyException Occur");
	}
	
	public MyException(String message) {
		super(message);
	}
}
