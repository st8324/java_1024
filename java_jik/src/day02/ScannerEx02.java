package day02;

import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		/* next() : 공백(스페이스, 탭, 엔터)을 제외한 한 단어를 입력 받음
		 *          다음 공백이 나오기 전까지 문자열을 가져옴
		 * nextLine() : 공백(스페이스, 탭)을 포함한 문자열을 가져옴
		 * */
		Scanner scan = new Scanner(System.in);
		
		System.out.println("한 문장을 입력하세요 : ");
		String str1 = scan.nextLine();
		System.out.println(str1);
		
		System.out.println("한 단어를 입력하세요 : ");
		String str2 = scan.next();
		System.out.println(str2);
		
		scan.close();
	}
}
