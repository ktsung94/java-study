package prob6;

import java.util.Scanner;

public class Prob06 {

	public static void main(String[] args) {
		// 숫자 +-/* 숫자  스페이스로 구분
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			System.out.print(">>");
			String expr = scanner.nextLine();
			
			if("quit".equals(expr))
				break;
			
			String[] tokens = expr.split(" ");
			
			if(tokens.length != 3) {
				System.out.println("지원하는 연산식이 아닙니다.");
				continue;
			}
			
			int lValue = Integer.parseInt(tokens[0]);
			int rValue = Integer.parseInt(tokens[2]);
			int result = 0;
			if("+".equals(tokens[1])) {
				Add add = new Add();
				add.setValue(lValue, rValue);
				result = add.calculate();
				System.out.println(">> " + result);
			}
			else if("-".equals(tokens[1])) {
				Sub add = new Sub();
				add.setValue(lValue, rValue);
				result = add.calculate();
				System.out.println(">> " + result);
			}
			else if("*".equals(tokens[1])) {
				Mul add = new Mul();
				add.setValue(lValue, rValue);
				result = add.calculate();
				System.out.println(">> " + result);
			}
			else if("/".equals(tokens[1])) {
				Div add = new Div();
				add.setValue(lValue, rValue);
				result = add.calculate();
				System.out.println(">> " + result);
			}
			else {
				System.out.println("지원하는 연산식이 아닙니다.");
				continue;
			}
		}
		
		scanner.close();
	}

}
