package day04;

public class NestingForStarEx02 {

	public static void main(String[] args) {
		/* *		row=1	*=1
		 * **		row=2	*=2
		 * ***		row=3	*=3
		 * ****		row=4	*=4
		 * *****	row=5	*=5
		 * 					*=row
		 * */
		int row, col;
		for( row = 1 ; row <= 5 ; row++ ) {
			//*을 row개 출력
			for(col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*     *	row=1	공백=4		*=1
		 *    **	row=2	공백=3		*=2
		 *   ***	row=3	공백=2		*=3
		 *  ****	row=4	공백=1		*=4
		 * *****	row=5	공백=0		*=5
		 * 					공백=5-row	*=row
		 * */
		for(row = 1; row <=5; row++) {
			//공백 출력 5-row개
			for(col = 1; col <= 5-row ; col++ ) {
				System.out.print(" ");
			}
			//*출력 row개
			for(col = 1; col <= row ; col++ ) {
				System.out.print("*");
			}
			//엔터
			System.out.println();
		}
		/*     *		row=1	공백=4	*=1		*=0
		 *    ** *		row=2	공백=3	*=2 	*=1
		 *   *** **		row=3	공백=2	*=3 	*=2
		 *  **** ***	row=4	공백=1	*=4 	*=3
		 * ***** ****	row=5	공백=0	*=5 	*=4
		 * 						공백=5-row*=row	*=row-1
		 * */
		for(row=1; row<=5; row++) {
			//공백
			for(col=1; col<=5-row; col++) {
				System.out.print(" ");
			}
			//* row개
			for(col=1; col<=row; col++) {
				System.out.print("*");
			}
			//* row-1개
			for(col=1; col<=row-1; col++) {
				System.out.print("*");
			}
			//엔터
			System.out.println();
		}
	}

}
