package day04;

public class NestingForStarEx01 {

	public static void main(String[] args) {
		/* *******
		 * *******
		 * *******
		 * *******
		 * *******
		 * */
		int col, row;
		for(row = 1; row <= 5; row++) {
			System.out.println("*****");
		}
		System.out.println("------");
		for(row = 1; row <= 5; row++) {
			for(col = 1; col <= 5; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
