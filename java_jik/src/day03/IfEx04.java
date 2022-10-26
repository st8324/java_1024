package day03;

public class IfEx04 {

	public static void main(String[] args) {
		//정수 num가 3의 배수이면 3의 배수라고 출력하고, 
		//아니면 3의 배수가 아닙니다를 출력하는 코드를 작성하세요.
		int num = 4;
		//num를 3으로 나누었을 때 나머지가 0과 같다면 3의 배수라고 출력
		if(num % 3 == 0) {
			System.out.println(num + "는 3의 배수");
		}
		//아니면 3의 배수가 아닙니다를 출력
		else {
			System.out.println(num + "는 3의 배수가 아님");
		}
	}

}
