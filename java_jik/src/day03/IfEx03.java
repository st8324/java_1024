package day03;

public class IfEx03 {

	public static void main(String[] args) {
		/* 조건식1이 참이면 실행문1을 실행
		 * if(조건식1){
		 * 		실행문1;
		 * } 
		 * 조건식1이 거짓이고 조건식2가 참이면 실행문2를 실행
		 * else if(조건식2){
		 * 		실행문2;
		 * } 
		 * 조건식1과 조건식2가 거짓이면 실행문3을 실행
		 * else{
		 * 		실행문3;
		 * }
		 * 
		 * if : 반드시 필요, 조건문을 시작, 1개
		 * else if : 0개 이상
		 * else : 0개 또는 1개
		 * */
		//정수가 양수, 음수, 0인지 판별하는 코드를 작성
		int num = 10;
		if(num > 0) {
			System.out.println(num + "는 양수");
		}else if(num == 0) {
			System.out.println(0);
		}else {
			System.out.println(num + "는 음수");
		}
	}
}
