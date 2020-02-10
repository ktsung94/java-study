package chapter03;

public class Goods2App {
	public static void main(String[] args) {
		Goods2 goods = new Goods2();
		
		goods.setName("nikon");
		goods.setPrice(-2000);
		goods.setCountSold(50);
		goods.setCountStock(100);
		
		System.out.println(goods.getName() + ":" + goods.getPrice() + ":" + goods.getCountSold() + ":" + goods.getCountStock());
	
		
		Goods2 goods2 = new Goods2("TV", 1000, 20, 50);
	
	}
	
}
