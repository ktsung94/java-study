package thread;

public class ThreadEx02 {

	public static void main(String[] args) {
		// 쓰레드는 같은 일을 객체로 만들어서 실행가능
		
		Thread thread1 = new DigitalThread();	// Thread 생성
		Thread thread2 = new AlphabetThread();	// Thread 생성
		Thread thread3 = new DigitalThread();	// Thread 생성
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
