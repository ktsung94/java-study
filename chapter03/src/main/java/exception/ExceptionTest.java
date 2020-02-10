package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 11 - a;


		System.out.println("some codes0");
		try {
			System.out.println("some codes1");
			int	result = (1+2+3) / b;	// 예외가 발생하는 순간 바로 catch로 간다.
			System.out.println("some codes2");
		} catch(ArithmeticException ex) {
			//System.out.println("some codes3");
			//System.out.println("예외 발생:" + ex);
			// 1. 사과
			System.out.println("미안합니다.....");
			// 2. 로그
			System.out.println(ex);
			// 3. 정상종료
			return;		// 종료
		} finally { // 예외 발생하고 종료할 때 finally를 한번 실행한다. (예외가 발생 안해도 실행한다.)
			System.out.println("some codes4");
		}
		System.out.println("some codes5");

	}

}
