package day12;

public class ObjectEx01 {

	public static void main(String[] args) {
		Student std1 = new Student();
		Student std2 = new Student();
		System.out.println(std1);
		System.out.println(std2);
		System.out.println("두 개체를 ==로 비교 : " + (std1 == std2));
		System.out.println("두 개체를 equals()로 비교 : " + (std1.equals(std2)));
	}

}
