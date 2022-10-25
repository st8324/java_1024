package day02;

public class OperatorEx06 {

	public static void main(String[] args) {
		/* 논리연산자
		 * && : 둘다 참이면 참, 나머진 거짓
		 *      ~이고, ~라고
		 * || : 둘다 거짓이면 거짓, 나머진 참
		 *      ~이거나
		 * ! : 반대, ~가 아닌
		 * */
		int score = 85;
		//boolean isB = score가 80점이상이고 score가 90점미만이다;
		//boolean isB = score가 80점이상이다 && score가 90점미만이다;
		//boolean isB = score가 80보다 크거나 같다 && score가 90 작다;
		boolean isB = score >= 80  && score < 90 ;
		System.out.println(score + "점은 B학점인가? " + isB);
	}

}
