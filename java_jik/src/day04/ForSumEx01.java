package day04;

public class ForSumEx01 {

	public static void main(String[] args) {
		/* 1부터 10 사이의 짝수의 합을 구하는 코드를 작성하세요.
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 짝수이면 sum += i를 실행
		 * 반복문 종료 후 : sum을 출력
		 * */
		int i, sum = 0;
		for(i = 1; i <= 10 ; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		System.out.println("1부터 10까지 짝수 합 : " + sum);
	}

}
