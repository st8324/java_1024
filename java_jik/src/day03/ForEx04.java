package day03;

public class ForEx04 {

	public static void main(String[] args) {
		/* 1부터 10사이의 짝수를 출력하는 코드를 작성하세요.
		 * 2 4 6 8 10
		 * */
		int i;
		/* 방법1 
		 * 반복횟수 : i는 1부터 5까지 1씩증가
		 * 규칙성 : 2*i를 출력
		 * */
		for( i = 1 ; i <= 5 ; i++ ) {
			System.out.print(2*i + " ");
		}
		System.out.println();
		for( i = 1 ; 2*i <= 10 ; i++ ) {
			System.out.print(2*i + " ");
		}
		System.out.println();
		/* 방법2
		 * 반복횟수 : i는 2부터 10까지 2씩 증가
		 * 규척성 : i를 출력
		 * */
		for(i = 2; i<= 10; i +=2) {
			System.out.print(i + " ");
		}
		System.out.println();
		/* 방법3
		 * 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 짝수이면 i를 출력
		 * */
		for(i = 1; i<=10; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}

}
