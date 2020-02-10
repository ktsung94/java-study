package practice01;

public class Prob5 {

	public static void main(String[] args) {
		for( int i = 1; i <=100; i++ ) {			
			/*
			 * 肄붾뱶 �옉�꽦�빀�땲�떎.
			 */
			String s = String.valueOf(i);
			boolean b0 = s.charAt(0) == '3' || s.charAt(0) == '6' || s.charAt(0) == '9';
			boolean b1 = false;
			if(s.length() == 2)
				b1 = s.charAt(1) == '3' || s.charAt(1) == '6' || s.charAt(1) == '9';

			if(b0 || b1) {
				System.out.print(i + " ");
				if(b0)
					System.out.print("짝");
				if(b1)
					System.out.print("짝");
				System.out.println();
			}
		}
	}
}
