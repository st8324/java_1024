package day18;

public class EnumEx01 {

	public static void main(String[] args) {
		/* 제한된 값들을 활용하는 변수가 필요할 때 열거형을 이용
		 * valueOf(문자열) : 문자열에 맞는 열거형으로 타입을 변환
		 * */
		Type type = Type.수입;
		System.out.println("구분 : " + type);
		type = Type.valueOf("수입");
		System.out.println("구분 : " + type);
	}
}
enum Type{ 수입,	지출 }
