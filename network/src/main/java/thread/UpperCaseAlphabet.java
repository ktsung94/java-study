package thread;

public class UpperCaseAlphabet extends Thread {
	public void print() {
		for(char c = 'A'; c < 'Z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);	// 1초동안 재움
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
