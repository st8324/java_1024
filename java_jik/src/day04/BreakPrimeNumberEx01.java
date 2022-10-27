package day04;

public class BreakPrimeNumberEx01 {

	public static void main(String[] args) {
		//break문을 이용하여 소수를 판별하는 예제
		int num = 11;
		int i;
		for(i=num-1; i >= 1; i--) {
			if(num % i == 0) {
				break;
			}
		}
		if(i == 1) {
			System.out.println(num + "는 소수");
		}else {
			System.out.println(num + "는 소수 아님");
		}
	}

}
