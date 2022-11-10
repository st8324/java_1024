package day14;

import java.util.Scanner;

public class ExceptionEx03 {

	public static void main(String[] args) {
		/* 다음과 같은 메뉴를 출력하고 정수를 입력받는 코드를 작성하세요.
		 * 단, 종료를 선택하면 프로그램이 종료되고, 예외처리를 적용하여 정수가 아닌 문자열이 
		 * 입력되도 프로그램이 계속 진행되도록 하세요.
		 * 
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 
		 * */
		int menu = -1;
		Scanner scan = new Scanner(System.in);
		do {
			printMenu();
			try {
				menu = scan.nextInt();
			}catch(Exception e) {
				System.out.println("입력을 잘못했습니다. 정수를 입력하세요.");
				scan.nextLine();
			}
		}while(menu !=3);
	}
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.플레이");
		System.out.println("2.기록확인");
		System.out.println("3.종료");
		System.out.print("메뉴 선택 : ");
	}
}
