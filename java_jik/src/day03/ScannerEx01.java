package day03;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		//문자를 입력받아 char에 저장하는 예제
		Scanner scan = new Scanner(System.in);
		char ch;
		System.out.print("문자를 입력하세요 : ");
		//charAt(숫자) : 문자열에서 제공하는 기능
		//문자열에서 숫자번지에 해당하는 문자를 알려줌. 시작 번지는 0번지부터
		ch = scan.next().charAt(0);
		System.out.println("입력 받은 문자는 " + ch + "입니다.");
		scan.close(); 
	}
}
