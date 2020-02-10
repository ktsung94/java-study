package practice01;

import java.util.Scanner;

public class Prob1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		
		System.out.print( "�닔瑜� �엯�젰�븯�꽭�슂 : " );
		int number = scanner.nextInt();
		
		/*
		 * 肄붾뱶 �옉�꽦�빀�땲�떎.
		 */
		if(number % 3 == 0)
			System.out.println("3의 배수입니다.");
		else
			System.out.println("3의 배수가 아닙니다.");
		
		scanner.close();
	}
}
