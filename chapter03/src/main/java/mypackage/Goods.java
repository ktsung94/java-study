package mypackage;

public class Goods {
	public static int countOfGoods;
	
	public Goods() {
		countOfGoods++; //Goods.countOfGoods = Goods.countOfGoods + 1;
	}
	public String name;		// 모든 접근 가능(접근 제한이 없음)
	protected int price;	// 같은 패키지 + 자식접근 가능
	int countSold;			// 같은 패키지
	private int countStock;	// 하나의 클레스에서만 접근 가능
	
}
