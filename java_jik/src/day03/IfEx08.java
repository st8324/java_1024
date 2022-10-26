package day03;

import java.util.Scanner;

public class IfEx08 {

	public static void main(String[] args) {
		/* 점수를 정수로 입력받아 입력받은 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * A : 90 ~ 100
		 * B : 80 ~ 89
		 * C : 70 ~ 79
		 * D : 60 ~ 69
		 * F : 0 ~ 59
		 * 잘못된 성적 : 그 외
		 * 
		 * */
		//정수를 입력받아 score에 저장
		Scanner scan = new Scanner(System.in);
		System.out.print("성적을 입력하세요 : ");
		int score = scan.nextInt();
		
		/* score가 90보다 크거나 같(고) score가 100보다 작거나 같으(면) A라고 출력
		 * score가 80보다 크거나 같고 score가 90보다 작으면 B라고 출력
		 * score가 70보다 크거나 같고 score가 80보다 작으면 C라고 출력
		 * score가 60보다 크거나 같고 score가 70보다 작으면 D라고 출력
		 * score가 0보다 크거나 같고 score가 60보다 작으면 F라고 출력
		 * score가 위의 조건을 만족하지 않으면 잘못된 점수라고 출력
		 * */
		if(score >= 90 && score <= 100) {
			System.out.println(score + "점은 A 학점");
		}else if(score >= 80 && score < 90) {
			System.out.println(score + "점은 B 학점");
		}else if(score >= 70 && score < 80) {
			System.out.println(score + "점은 C 학점");
		}else if(score >= 60 && score < 70) {
			System.out.println(score + "점은 D 학점");
		}else if(score >= 0 && score < 60) {
			System.out.println(score + "점은 F 학점");
		}else {
			System.out.println(score + "점은 잘못된 성적입니다.");
		}
		
		if(score > 100 || score < 0) {
			System.out.println(score + "점은 잘못된 성적입니다.");
		}else if(score >= 90) {
			System.out.println(score + "점은 A 학점");
		}else if(score >= 80) {
			System.out.println(score + "점은 B 학점");
		}else if(score >= 70) {
			System.out.println(score + "점은 C 학점");
		}else if(score >= 60) {
			System.out.println(score + "점은 D 학점");
		}else {
			System.out.println(score + "점은 F 학점");
		}
		scan.close();
	}

}
