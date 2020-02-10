package practice02;

public class Prob04 {

	public static void main(String[] args) {
		char[] c1 = reverse("Hello World");
		printCharArray( c1 );

		char[] c2 = reverse("Java Programming!");
		printCharArray( c2 );
	}

	public static char[] reverse(String str) {
		char[] result = str.toCharArray();
		char temp;
		for(int i = 0; i < result.length/2; i++) {
			temp = result[i];
			result[i] = result[result.length-1-i];
			result[result.length-1-i] = temp;
		}
		return result;
	}

	public static void printCharArray(char[] array) {
		System.out.println(array);
	}
}
