package thread;

public class DigitalThread extends Thread {

	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.print(i);
			try {
				Thread.sleep(1000);	// 1초동안 재움
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
