package day02;

import java.util.Scanner;

public class OperatorEx05 {

	public static void main(String[] args) {
		/* 홍길동 학생의 국어, 영어, 수학 점수를 콘솔에서 입력받고(Scanner),
		 * 홍길동 학생 평균 성적을 콘솔에 출력(System.out.println)하는 코드를 작성하세요.
		 * 테스트는 81 90 100을 입력하여 90.333333 이 나와야 합니다.
		 * */
		//국어, 영어, 수학, 총점, 평균
		int kor, eng, math, sum;
		double avg;

		//Scanner를 통해 성적을 입력
		Scanner scan = new Scanner(System.in);
		
		System.out.print("국어 성적을 입력하세요 : ");
		kor = scan.nextInt();
		System.out.print("영어 성적을 입력하세요 : ");
		eng = scan.nextInt();
		System.out.print("수학 성적을 입력하세요 : ");
		math = scan.nextInt();
		
		scan.close();
		//총점을 계산
		sum = kor + eng + math;
		
		//평균을 계산
		avg = (double)sum / 3.0;
		
		//평균을 출력
		System.out.println("평균은 " + avg + "입니다.");
		
		//통과입니까? true/false
		//평균이 60점이상이면 true, 아니면 false
		//통과를 알려주는 변수, 실패를 알려주는 변수
		boolean isPass = avg >= 60;
		boolean isFail = avg < 60;
		System.out.println("통과입니까? " + isPass);
		System.out.println("통과입니까? " + !isFail);
	}

}
