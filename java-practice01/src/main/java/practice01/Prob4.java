package practice01;

import java.util.Scanner;

public class Prob4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("문자열을 입력하세요. : ");
		String srt = scanner.nextLine();

		/*
		 * 肄붾뱶 �옉�꽦�빀�땲�떎.
		 */
		for(int i = 0; i < srt.length(); i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(srt.charAt(j));
			}
			System.out.println();
		}
		
		scanner.close();
	}

}
