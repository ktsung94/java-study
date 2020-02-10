package chapter03;

public class StaticMethod {
	// 객체는 데이터만있고 코드는 없다.
	int n;
	static int m;
	
	void f1() {
		System.out.println(n);
	}
	
	void f2() {
		System.out.println(m);
		// 같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략이 가능하다.
		System.out.println(StaticMethod.m);
	}
	
	void f3() {
		
	}
	
	void f4() {
		StaticMethod.s1();
		s1();
	}
	
	static void s1() {
		// static method 에서 인스턴스 변수 접근은 안된다.
		// 오류 : System.out.println(n);
	}
	
	static void s2() {
		System.out.println(m);
	}
	
	static void s3() {
		// 오류 static method 에서 인스턴스 메소드 접근은 안된다.
		// f1();
	}
	
	static void s4() {
		StaticMethod.s1();
		// 같은 클래스의 클래스 변수 접근에서는 클래스 이름 생략이 가능하다.
		s1();
	}
}
