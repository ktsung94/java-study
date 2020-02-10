package chapter03;

public class Student extends Person {
	public Student() {
		// 자식 생성자에서 보무 생성자를 명시적으로 호출하지 않으면
		// 자동으로 부모의 기본 생성자를 호출하게 된다.
		// super(); 를 안쓰면 컴파일러가 자동으로 써줌.
		System.out.println("Student() called");
	}
}
