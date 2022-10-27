package day04;

public class BreakLCMEx01 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요. 
		 * 2의 배수 : 2,4,6,8,10,...
		 * 3의 배수 : 3,6,9,12...
		 * 2와 3의 공배수 : 6, 12, 18, ...
		 * 2와 3의 최소 공배수 : 6
		 * 반복횟수 : i는 num1부터 num1*num2까지 num1씩 증가
		 * 규칙성 :  i가 num1과 num2의 배수이면 i를 출력후 반복문 종료
		 * 		  =>i가 num1의 배수이고, i가 num2의 배수이면 i를 출력후 반복문 종료
		 * 		  =>i를 num1으로 나누었을 때 나머지가 0과 같고, 
		 * 			i를 num2로 나누었을 때 나머지가 0과 같다면
		 * 			i를 출력후 반복문 종료 
		 * 		  =>i를 num1으로 나누었을 때 나머지가 0과 같다 &&
		 * 			i를 num2로 나누었을 때 나머지가 0과 같다
		 * 		  =>i % num1 == 0 && i % num2 == 0
		 * 반복문 종료 후 : 없음
		 *  */
		int num1 = 8, num2 = 12;
		int i;
		for(i = num1; i <= num1*num2; i += num1) {
			if(i % num1 == 0 && i % num2 == 0) {
				System.out.println(num1+"과 " + num2 +"의 최소 공배수 : " +i);
				break;
			}
		}
	}

}
