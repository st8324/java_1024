package day03;

import java.util.Scanner;

public class SwitchEx04 {

	public static void main(String[] args) {
		/* 월을 입력받아 해당하는 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 31 : 1 3 5 7 8 10 12
		 * 30 : 4 6 9 11
		 * 28 : 2
		 * 예시 
		 * 월을 입력하세요 : 1
		 * 1월은 31일까지 있습니다.
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.print("월을 입력하세요 : ");
		int month = scan.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		default:
			System.out.println(month + "월은 없습니다.");
		}
		
		scan.close();
	}

}
