package p04;

import java.util.Scanner;

public class Prob04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("문자열을 입력하세요. : ");
		String str = input.nextLine();
		
		for(int i=1; i<=str.length(); i++) {
			System.out.println(str.substring(0, i));
		}
	}

}
