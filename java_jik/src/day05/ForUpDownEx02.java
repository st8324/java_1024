package day05;

import java.util.Scanner;

public class ForUpDownEx02 {

	public static void main(String[] args) {
		/* 랜덤한 정수를 맞추는 UP DOWN 게임
		 * 예시
		 * 1~100사이의 랜덤한 수를 맞추세요.
		 * 숫자를 입력하세요 : 50
		 * UP
		 * 숫자를 입력하세요 : 75
		 * DOWN
		 * 숫자를 입력하세요 : 65
		 * UP
		 * 숫자를 입력하세요 : 70
		 * 정답입니다.
		 * 더하시겠습까?(y/n) : y
		 * 1~100사이의 랜덤한 수를 맞추세요.
		 * 숫자를 입력하세요 : 50
		 * UP
		 * 숫자를 입력하세요 : 75
		 * DOWN
		 * 숫자를 입력하세요 : 65
		 * UP
		 * 숫자를 입력하세요 : 69
		 * 정답입니다.
		 * 더하시겠습까?(y/n) : n
		 * 프로그램을 종료합니다.
		 * */
		
		/* 반복횟수 : 없음
		 * 규칙성 :
		 *  - 1. 게임 한판 함
		 *  - 2. 더하시겠습니까?(y/n)를 출력
		 *  - 3. 문자 하나를 입력
		 *  - 4. 입력받은 문자가 n이면 종료
		 * */
		int min = 1, max = 100;
		int r, num;
		Scanner scan = new Scanner(System.in);
		
		for( ; ; ) {
			r = (int)(Math.random()*(max - min + 1)+min);
			System.out.println(min + " ~ " + max + "사이의 랜덤한 수를 맞추세요.");
			num = min - 1;
			for( ; r != num ; ) {
				System.out.print("숫자를 입력하세요 : ");
				num = scan.nextInt();
				if(num == r) {
					System.out.println("정답입니다.");
				}
				else if(num > r) {
					System.out.println("DOWN");
				}
				else {
					System.out.println("UP");
				}
			}
			System.out.print("더하시겠습니까?(y/n) : ");
			if(scan.next().charAt(0) == 'n') {
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		scan.close();
	}
}
