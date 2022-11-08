package example.br31;

import java.util.Scanner;

public class BR31Manager {

	public static void main(String[] args) {
		Record record = new Record(5);
		int menu;
		do {
			printMenu();
			menu = inputInt();
			run(menu, record);
		}while(menu != 3);
		
	}

	private static void run(int menu, Record record) {
		switch(menu) {
		case 1:
			boolean res = play();
			record.addRecord(res);
			if(res) {
				System.out.println("사용자가 이겼습니다.");
			}else {
				System.out.println("컴퓨터가 이겼습니다.");
			}
			break;
		case 2:
			record.printResult();
			break;
		case 3:
			System.out.println("프로그램 종료!");
			break;
		default:	
			System.out.println("잘못된 메뉴!");
		}
		
	}
	
	/**
	 * min~max사이의 랜덤으로 정수를 선택하여 알려주는 메소드
	 * @param min 최소값
	 * @param max 최대값
	 * @return min~max 사이의 정수
	 */
	private static int random(int min, int max) {
		return (int)(Math.random()*(max - min + 1) + min);
	}
	
	/**
	 * 31 피하기 게임을 진행하여 사용자가 이기면 true를 컴퓨터가 이기면 false를 알려주는 메소드
	 * @return 사용자가 이겼는지 졌는지 여부
	 */
	private static boolean play() {
		int start = 1;
		int min = 1, max = 3;
		do {
			int com = random(min, max);
			com = checkNum(start, com, 3, 31);
			System.out.print("com : ");
			printNums(start , start+com);
			if(start + com > 31) {
				return true;
			}
			start = start + com;
			System.out.print("사용자 입력(1~3) : ");
			int user = inputInt();
			user = checkNum(start, user, 3, 31);
			System.out.print("user : ");
			printNums(start , start+user);
			if(start + user > 31) {
				return false;
			}
			start = start + user;
		}while(start <= 31);
		return false;
	}
	/**
	 * 정수 num가 maxCount개 이하이고, 
	 * 정수 start부터 차례대로 num개의 정수를 불렀을 때 maxNum를
	 * 넘지 않도록 num의 개수를 다시 정해주는 메소드
	 * @param start 시작 정수
	 * @param num 판별해야할 정수
	 * @param maxCount num가 가질수 있는 최대 정수
	 * @param maxNum start + num를 했을 때 가질 수 있는 최대 정수
	 * @return
	 */
	private static int checkNum(int start, int num, int maxCount, int maxNum) {
		num = num > maxCount ? maxCount : num;
		num = maxNum - start - num < 0 ? maxNum - start + 1 : num;
		return num;
	}
	/**
	 * start부터 end보다 작은 정수를 차례대로 출력하는 메소드
	 * @param start 시작 수 
	 * @param end 마지막 수 + 1
	 */
	private static void printNums(int start, int end) {
		for(int i = start; i< end; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	/**
	 * 스캐너를 통해 정수를 입력받아 입력받은 정수를 알려주는 메소드
	 * @return 입력받은 정수
	 */
	private static int inputInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	/**
	 * 메뉴를 출력하는 메소드
	 */
	private static void printMenu() {
		System.out.println("-----------");
		System.out.println("1. 플레이");
		System.out.println("2. 기록확인");
		System.out.println("3. 종료");
		System.out.println("-----------");
		System.out.print("메뉴 선택 : ");
	}

}
