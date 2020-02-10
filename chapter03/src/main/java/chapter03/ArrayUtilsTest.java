package chapter03;

public class ArrayUtilsTest {

	public static void main(String[] args) {
		int[] a1 = {10, 20, 30, 40, 50};
		
		//ArrayUtils au = new ArrayUtils();
		//double[] d1 = au.intToDouble(a1);
		
		// static이 아닌경우 객체를 생성해야함.
		double[] d1 = ArrayUtils.intToDouble(a1);
		
		for(int i = 0; i < d1.length; i++) {
			System.out.println(d1[i] + " ");
		}
		
	}

}
