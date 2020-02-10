package chapter03;

public class ArrayUtils {
	public static double[] intToDouble(int[] src) {
		double[] result = null;
		
		if(src == null)
			return result;
		
		int size = src.length;
		result = new double[size];
		
		for(int i = 0; i < size; i++) {
			result[i] = src[i]; // 작은곳에서 큰곳으로 가기 떄문에 굳이 캐스팅을 안해도됨.
		}
		
		return null;
	}
}
