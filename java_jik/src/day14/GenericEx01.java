package day14;

public class GenericEx01 {

	public static void main(String[] args) {
		/* 컬렉션은 제네릭 클래스이다.
		 * 제네릭 클래스는 필드의 클래스가 객체 생성시 정해지는 클래스
		 * 클래스명<클래스명> 객체명 = new 생성자<클래스명>();
		 * */
		A<Integer> a = new A<Integer>();
		a.num = 10;
		System.out.println(a.num);
		
		A<String> b = new A<String>();
		b.num = "Hello";
		System.out.println(b.num);

	}

}
class A<T>{
	T num;
}

