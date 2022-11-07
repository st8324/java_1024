package day11;

public class InheritanceEx01 {
	public static void main(String[]args) {
		/* A is a B로 표현이 가능하면 상속을 한다.
		 * A가 자식(파생) 클래스, B가 부모클래스
		 * 스마트폰은 폰이다 => O
		 * 스마트폰은 카메라이다 => X 
		 * 폰은 스마트폰이다 => X 
		 * 현대차는 자동차이다 => O
		 * A has a B로 표현이 가능하면 포함을 한다. => B가 A클래스의 필드로 선언
		 * 스마트폰은 카메라를 가지고 있다. => O
		 * 자동차는 바퀴를 가지고 있다 => O 
		 * */
		Child1 c = new Child1();
		c.print();
		
	}
}

class Child1 extends Parent1{
	public Child1() {
		super(1,2,3);
		//num1 = 10; //접근제한자가 private이어서 자식클래스에서 사용하지 못함
		num2 = 20; //접근제한자가 디폴트이어서 같은 패키지에 있기 때문에 가능
				   //상속 여부와 상관이 없다
		num3 = 30; //접근제한자가 protected이어서 자식클래스에서 사용할 수 있다
				   //다른 패키지이어도 사용 가능
	}
	

	public void print() {
		super.print();
		System.out.println("자식 클래스의 메소드입니다.");
	}
}
class Parent1{
	
	private int num1 = 1;
	int num2 = 2;
	protected int num3 = 3;
	
	public void print() {
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
	public Parent1(int num1, int num2, int num3) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
	}
}
