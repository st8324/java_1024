package day10;

import java.util.Arrays;

public class BaseballGame {
	private int []com;
	private int []user;
	private int strike;
	private int ball;

	public BaseballGame(int []com) {
		this.com = Arrays.copyOf(com, com.length);
	}
	public void setUser(int []user) {
		this.user = Arrays.copyOf(user, user.length);
		calculateResult();
	}
	private void calculateResult() {
		calculateStrike();
		calculateBall();
	}
	private void calculateStrike() {
		int count = 0;
		//4 1 3
		//1 2 3 4
		int size = com.length < user.length ? com.length : user.length;
		for(int i = 0; i<size; i++) {
			if(com[i] == user[i]) {
				count++;
			}
		}
		strike = count;
	}
	private void calculateBall() {
		int count = 0;
		for(int i = 0; i<com.length; i++) {
			for(int j = 0; j<user.length; j++) {
				if(com[i] == user[j] && i!=j) {
					count++;
				}
			}
		}
		ball = count;
	}
	public void printResult() {
		if(strike != 0) {
			System.out.print(strike+"S ");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("OUT");
		}
		System.out.println();
	}
	public int getStrike() {
		return strike;
	}
}
