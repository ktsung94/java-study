package practice02;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		while(true) {
			int low = 1;
			int high = 100;
			int num = 1;
			int count = 0;
			Scanner scanner = new Scanner(System.in);
			Random r = new Random();
			int result = r.nextInt(100) + 1;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");

			while(true) {
				System.out.println(low + "-" + high);
				System.out.print(++count + ">>");
				num = scanner.nextInt();

				while(num < low || num > high) {
					System.out.println("다시 입력하세요 ");
					num = scanner.nextInt();
				}

				if(num < result) {
					low = num;
					System.out.println("더 높게");
				}
				else if(num == result) {
					System.out.println("맞았습니다.");
					break;
				}
				else {
					high = num;
					System.out.println("더 낮게");
				}
			}

			System.out.print("다시하시겠습니다?(y/n)>>");
			String answer = scanner.next();
			while(!answer.equals("y") && !answer.equals("n")) {
				System.out.println("다시 입력하세요");
				answer = scanner.next();
			}
			if(answer.equals("n"))
				break;
		}
	}

}

