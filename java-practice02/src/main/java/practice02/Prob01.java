package practice02;

import java.util.Scanner;

public class Prob01 {

	public static void main(String[] args) {
		final int[] MONEYS = { 50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1 };

		Scanner scanner = new Scanner(System.in);

		System.out.print("금액:");
		int c = 50000;
		int n = 0;
		int a = 1;
		int m = scanner.nextInt();
		
		while (m > 0) {
			if(m > c) {
				n = m/c;
				m -= c*n;
				System.out.println(c + "원 : " + n + "개");
			}
			if(a == 1)
				c /= 5;
			else
				c /= 2;
			a *= -1;
		}
		/*
		 * 코드 작성합니다.
		 */

		scanner.close();
	}

}
