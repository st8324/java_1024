package day25;

import java.util.Scanner;

public class Ex04_2 {
	/* 컴퓨터와 가위, 바위, 보를 하는 프로그램을 작성하세요.
	 * - 사용자가 연속 3번 이길때까지 반복
	 * 예:
	 * 사용자 : 가위
	 * 컴퓨터 : 보
	 * 사용자 : 가위
	 * 컴퓨터 : 주먹
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		do {
			try {
				System.out.print("사용자 : ");
				RPS user = RPS.valueOf(scan.next());
				RPS com = randomRPS();
				System.out.println("컴퓨터 : " + com);
				State state = resultState(user, com);
				printState(state);
			}catch(IllegalArgumentException e) {
				System.out.println("입력을 잘 못했습니다.");
			}
			System.out.print("더 하시겠습니까?(y/n) : ");
		}while(!scan.next().equals("n"));
		
		scan.close();
	}

	private static void printState(State state) {
		switch(state) {
		case WIN:
			System.out.println("사용자가 이겼습니다.");
			break;
		case LOSE:
			System.out.println("컴퓨터가가 이겼습니다.");
			break;
		default:
			System.out.println("비겼습니다.");
		}
		
	}

	private static State resultState(RPS user, RPS com) {
		if(user == com) 
			return State.DRAW;
		switch(user) {
		case 가위:
			return com == RPS.보 ? State.WIN : State.LOSE; 
		case 바위:
			return com == RPS.가위 ? State.WIN : State.LOSE; 
		default:
			return com == RPS.바위 ? State.WIN : State.LOSE; 
		}
	}

	private static RPS randomRPS() {
		RPS [] rpss = RPS.values();
		int r = (int)(Math.random()*3);
		return rpss[r];
	}
}
enum RPS{
	가위, 바위, 보
}
enum State{
	WIN, LOSE, DRAW
}
