package day04;

public class BreakEx01 {

	public static void main(String[] args) {
		int i;
		//break를 만나면 증감식으로 가지 않고, 반복문을 빠져 나감

		for(i=1; i<=5; i++) {
			System.out.println("Hello world!");
			if(i == 3) {
				break;
			}
		}
	}
}
