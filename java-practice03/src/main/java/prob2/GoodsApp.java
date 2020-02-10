package prob2;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		for(int i = 0; i < COUNT_GOODS; i++) {
			String name = scanner.next();
			int price = scanner.nextInt();
			int count = scanner.nextInt();
			goods[i] = new Goods(name, price, count);
		}
		
		for(int i = 0; i < COUNT_GOODS; i++) {
			System.out.println(goods[i].getName()+"(가격:"+goods[i].getPrice()+"원)이 "+goods[i].getCount()+"개 입고 되었습니다.");
		}

		scanner.close();
	}
}
