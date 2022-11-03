package day09;

public class ThisEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test03 t1 = new Test03();
		
		Test03 t2 = new Test03(10);
	}

}
/* this : 객체 본인을 나타내는 참조변수
 *  - 주로 매개변수의 이름과 필드의 이름이 같으면서 메소드안에서 같이 사용될 때
 *    => 메소드에서 매개변수의 이름과 필드의 이름이 같으면 변수를 호출했을 때 매개변수가 불려짐
 *  - 메소드명이 길때 자동완성을 위해서 사용
 * this() : 해당 클래스의 생성자를 호출, 생성자에서 첫번째줄에 추가
 * */
class Test03{
	private int num;
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public void print() {
		System.out.println(this.getNum());
	}
	public Test03() {
		this(10);
		num = 20;
	}
	public Test03(int num) {
		this.num = num;
	}
}
 