package day31;

import lombok.Data;

public class CopyEx01 {

	public static void main(String[] args) {
		//얕은 복사
		Test t1 = new Test(10,20,"홍길동");
		
		Test t2 = t1;
		System.out.println("t1 : " + t1);
		System.out.println("t2 : " + t2);
		
		System.out.println("------------");
		t1.setNum1(30);
		t1.getSub().setName("임꺽정");
		System.out.println("t1 : " + t1);
		System.out.println("t2 : " + t2);
		
		//깊은 복사
		Test t3 = new Test(10,20,"홍길동");
		Test t4 = new Test(t3);
		System.out.println("------------");
		System.out.println("t3 : " + t3);
		System.out.println("t4 : " + t4);
		
		System.out.println("------------");
		t3.setNum1(30);
		t3.getSub().setName("임꺽정");
		System.out.println("t3 : " + t3);
		System.out.println("t4 : " + t4);
	}
}
@Data
class Test{
	int num1, num2;
	Sub sub;
	public Test(int num1, int num2, String name) {
		this.num1 = num1;
		this.num2 = num2;
		this.sub = new Sub(name);
	}
	
	public Test(Test t) {
		this.num1 = t.num1;
		this.num2 = t.num2;
		//깊은 복사를 하려면 필드가 참조변수인 경우, 
		//생성자를 이용하여 복사해야됨
		this.sub = new Sub(t.sub.getName());
		//this.sub = new Sub(t.sub);
	}
}

@Data
class Sub{
	String name;
	public Sub(String name) {
		this.name = name;
	}
	public Sub(Sub sub) {
		this.name = sub.name;
	}
}