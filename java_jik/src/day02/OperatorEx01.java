package day02;

public class OperatorEx01 {

	public static void main(String[] args) {
		//!(Not)연산자 : 참 또는 거짓인 값(변수, 리터럴, 조건식) 앞에 옴
		boolean isMale = true;
		boolean isFemale = false;
		System.out.println("남성입니까? : " + isMale + "," + !isFemale);
		System.out.println("여성입니까? : " + !isMale + "," + isFemale);
		
	}

}
