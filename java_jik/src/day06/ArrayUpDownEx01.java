package day06;

import java.util.Scanner;

public class ArrayUpDownEx01 {

	public static void main(String[] args) {
		/* Up Down 게임을 3회 반복해서 플레이 하고,
		 * 각 게임당 맞춘 횟수를 배열에 저장하여 출력하는
		 * 코드를 작성하세요. */
		int coin = 3;
		int record[] = new int[coin];
		int min = 1, max = 100;
		Scanner scan = new Scanner(System.in);
		
		while(coin-- > 0) {
			int r = (int)(Math.random()*(max - min + 1)+min);
			System.out.println(r);
			System.out.println(min + " ~ " + max + "사이의 랜덤한 수를 맞추세요.");
			int num;
			int tryCount = 0;
			do {
				tryCount++;
				System.out.print("숫자 입력 : ");
				num = scan.nextInt();
				if(num == r) {
					System.out.println("정답입니다.");
					record[record.length - coin - 1] = tryCount;
				}else if(num > r) {
					System.out.println("DOWN");
				}
				else {
					System.out.println("UP");
				}
			}while(r != num);
		}
		for(int i = 0; i<record.length; i++) {
			System.out.println(i+1+"번째 게임 횟수 : " + record[i]);
		}
		scan.close();
	}

}
