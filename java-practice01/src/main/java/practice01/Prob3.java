package practice01;

import java.util.Scanner;

public class Prob3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int n = scanner.nextInt();
		int result = 0;
		int a;
		if(n % 2 == 0)
			a = 0;
		else
			a = 1;
		while (true) {
			/*
			 * 코드 작성합니다.
			 */
			if(a > n) {
				System.out.println("결과 값 : " + result);
				break;
			}
			result += a;
			a += 2;
		}
	}
}
