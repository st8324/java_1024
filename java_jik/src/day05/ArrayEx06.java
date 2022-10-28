package day05;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		/* 정수 4개짜리 배열을 생성한 후, 4자리 숫자를 입력받아 배열에 저장하는 코드를
		 * 작성하세요.
		 * 1234
		 * 0번지 : 1
		 * 1번지 : 2
		 * 2번지 : 3
		 * 3번지 : 4
		 * */
		//4자리 정수를 입력
		Scanner scan = new Scanner(System.in);
		int size = 4;
		System.out.print(size+"자리 정수를 입력하세요 : ");
		int num = scan.nextInt();
		
		/* 반복횟수 : 4번 =>
		 * 규칙성 : 
		 * num에서 1의 자리를 추출				1234에서 4를 추출
		 * 추출된 1의 자리를 배열에 저장			arr[3] = 4
		 * => % 10
		 * num에서 1의 자리를 제거하여 num에 저장	1234에서 123을 num에 저장
		 * => / 10
		 * 반복문 종료 후 : 배열에 있는 값을 출력
		 * */
		int num2 = num;
		int arr[] = new int[size];
		for(int i = size-1; i>= 0; i--) {
			arr[i] = num % 10;
			num = num / 10;//num /= 10;
		}
		for(int tmp:arr) {
			System.out.print(tmp);
		}
		
		System.out.println();
		int i = size - 1;
		while(num2 > 0) {
			arr[i--] = num2 % 10;
			num2 = num2 / 10;//num /= 10;
		}
		for(int tmp:arr) {
			System.out.print(tmp);
		}
	}

}
