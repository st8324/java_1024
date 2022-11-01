package day07;

public class MethodEx03 {

	public static void main(String[] args) {
		printPrimeNumber(5);
		System.out.println(isPrimeNumber(5));
	}
	/* 기능 : 정수가 주어지면 소수인지 아닌지 출력하는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 출력 => 없음 => void
	 * 메소드명 : printPrimeNumber
	 * */
	public static void printPrimeNumber(int num) {
		int i, count;
		for(i = 1, count=0; i<= num; i++) {
			if(num % i == 0) {
				count++;
			}
		}
		if(count == 2) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수가 아님");
		}
	}
	/* 기능 : 정수가 주어지면 소수인지 아닌지 알려주는 메소드
	 * 매개변수 : 정수 => int num
	 * 리턴타입 : 소수인지 아닌지 => boolean
	 * 메소드명 : isPrimeNumber
	 * */
	public static boolean isPrimeNumber(int num) {
		for(int i = 2; i< num; i++) {
			//1과 num를 제외한 약수
			if(num % i == 0) {
				return false;
			}
		}
		return num <= 1 ? false : true;
	}
}
