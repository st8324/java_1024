package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/* 학생 5명의 국어 성적(정수)을 입력받고 출력하는 코드를 작성하세요. 
		 * 반복횟수 : i는 0부터 배열의 크기보다 작을때까지 1씩 증가
		 * 규칙성 : 콘솔에서 입력받은 정수를 배열 i번지에 저장 후 배열 i번지에 있는 값을 출력
		 * */
		int score[] = new int[5];
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i<score.length; i++) {
			System.out.print(i+1 +"번째 학생 성적 : ");
			score[i] = scan.nextInt();
			System.out.println(i+1 +"번째 학생 성적 : " + score[i]);
		}
		/* 학생 성적의 평균을 구하는 코드를 작성하세요.
		 * 반복횟수 : i는 0부터 배열의 크기보다 작을때까지 1씩 증가(향상된 for문 이용 가능)
		 * 규칙성 : sum에 배열 i번지에 있는 값을 누적
		 * 반복문 종료 후 : sum을 배열의 크기로 나눈 값을 출력(나누기 조심)
		 * */
		int sum = 0;
		for(int i = 0; i < score.length; i++) {
			sum +=  score[i];
		}
		double avg = (double)sum / score.length;
		System.out.println("학생들의 평균 : " + avg);
		
		//향상된 for문 이용
		sum = 0;
		for(int tmp : score) {
			sum += tmp;
		}
		avg = (double)sum / score.length;
		System.out.println("학생들의 평균 : " + avg);
		scan.close();
	}

}
