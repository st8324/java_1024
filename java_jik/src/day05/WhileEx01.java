package day05;

public class WhileEx01 {

	public static void main(String[] args) {
		/* while문 문법
		 * 
		 * while(조건식){
		 * 		실행문;
		 * }
		 * 
		 * 초기화;
		 * while(조건식){
		 * 		실행문;
		 * 		증감식;
		 * }
		 * 
		 * continue는 while문에서 조건식으로 이동
		 * */
		int i;
		i = 1;
		while( i++ <=5) {
			System.out.println("Hello wolrd!");
		}
		/* while문에서는 조건식을 생략할 수 없다.
		 * while문에서 무한루프를 만들려면 조건식에 true를 넣어주면 된다. */
	}

}
