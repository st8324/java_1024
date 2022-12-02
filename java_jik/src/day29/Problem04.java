package day29;

public class Problem04 {

	static String str;
	
	public static void main(String[] args) {
		/* 아래 코드 실행 시 결과를 작성하고 원인을 설명하세요.
		 * NullPointerException이 발생. 
		 * 필드 str은 null로 초기화 되어 있는데, 
		 * 문자열을 저장하지 않고 메소드를 호출했기 때문에
		 * */
		System.out.println(str.substring(0));

	}

}
