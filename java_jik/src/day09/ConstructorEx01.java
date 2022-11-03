package day09;

public class ConstructorEx01 {

	public static void main(String[] args) {
		Test01 t1 = new Test01();
		//Test02클래스는 기본 생성자가 없기 때문에 기본 생성자로 초기화 할 수 없다
		//Test02 t2 = new Test02();//에러 발생
		Test02 t2 = new Test02(10);
		//Scanner 클래스는 기본 생성자를 구현하지 않았기 때문에 기본생성자를 이용하여
		//초기화 할 수 없다
		//Scanner scan = new Scanner();
	}

}
/* 클래스에 생성자를 하나도 구현하지 않으면 기본 생성자가 자동으로 추가 됨
 * 클래스에 생성자가 하나라도 있으면 기본 생성자가 자동으로 추가되지 않음
 * */
class Test01{
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
class Test02{
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Test02(int num1) {
		num = num1;
	}
}