package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitalThread();	// Thread 생성
		Thread thread2 = new AlphabetThread();	// Thread 생성
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnableImpl());	// 일반 클래스로 만들고 Thread로 생성한다.
		
		thread1.start();
		thread2.start();
		thread3.start();

	}

}
