package day14;

public class WrapperEx01 {

	public static void main(String[] args) {
		int num1 = 1;
		Integer num2 = num1;//박싱(boxing)
		//num2 = null;
		int num3 = num2;//언박싱(unboxing)
		//num2인 Integer 객체를 int로 언박싱하는 경우 num2가 null일 수 있어서 조심해야 함
		System.out.println(num3);
		
		//문자열을 정수로
		String str ="1234";
		System.out.println(str+1);
		int num4 = Integer.parseInt(str);
		System.out.println(num4+1);

		//정수를 문자열로
		int num5 = 123;
		String str2 = Integer.valueOf(num5).toString();
		System.out.println(str2+1);
		String str3 = ""+num5;
		System.out.println(str3+1);
	}

}
