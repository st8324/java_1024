package day08;

import java.util.Arrays;
import java.util.Scanner;

public class MethodLottoEx01 {

	public static void main(String[] args) {
		int min = 1, max = 45;
		int size = 6;
		//로또 번호 생성
		int [] lotto = createRandomArray(min, max, size);
		//로또 번호 정렬
		Arrays.sort(lotto);
		//로또 번호 출력
		System.out.print("로또 번호 : ");
		printArray(lotto);
		//보너스 번호 생성
		int bonus;
		do {
			bonus = random(min, max);
		}while(contains(lotto, bonus));
		System.out.println("보너스 번호 : " + bonus);
		
		//로또 번호 입력
		int []user = new int [size];
		System.out.print("입력 번호 : ");
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i<user.length; i++) {
			user[i] = scan.nextInt();
		}
		scan.close();
		
		int rank = getRank(lotto, bonus, user);
		printRank(rank);
		
	}
	
	/* 기능 : 로또 번호(보너스 번호 포함)와 입력번호가 주어지면 등수를 알려주는 메소드
	 * 매개변수 : 로또번호, 입력번호 => int []lotto, int bonus, int []user
	 * 리턴타입 : 등수 => 정수 => int
	 * 메소드명 : getRank
	 * */
	public static int getRank(int []lotto, int bonus, int []user) {
		int count = countLotto(lotto, user);
		switch(count) {
		case 6:		return 1;
		case 5:		return contains(user, bonus)? 2 : 3;	
		case 4:		return 4;
		case 3:		return 5;
		default:	return -1;
		}
	}
	/* 기능 : 등수가 주어지면 등수를 콘솔에 출력하는 메소드
	 * 매개변수 : 등수 => 정수 => int rank
	 * 리턴타입 : 없음 => void
	 * 메소드명 : printRank
	 * */
	public static void printRank(int rank) {
		switch(rank) {
		case 1:		System.out.println("1등!");	break;
		case 2:		System.out.println("2등!");	break;
		case 3:		System.out.println("3등!");	break;
		case 4:		System.out.println("4등!");	break;
		case 5:		System.out.println("5등!");	break;
		case -1:	System.out.println("꽝!");	break;
		}
	}
	
	/* 기능 : 주어진 두 배열에서 일치하는 숫자의 개수를 알려주는 메소드
	 * 매개변수 : 두 배열 => int [] arr1, int [] arr2
	 * 리턴타입 : 일치하는 숫자의 개수 => 정수 => int
	 * 메소드명 : countLotto
	 * */
	public static int countLotto(int []arr1, int []arr2) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0;
		for(int tmp : arr1) {
			if(contains(arr2, tmp)) {
				count++;
			}
		}
		return count;
	}
	
	
	public static void printArray(int arr[]) {
		if(arr == null) {
			return;
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int [] createRandomArray(int min, int max, int size) {
		if(max - min + 1 <= size) {
			return null;
		}
		int arr[] = new int[size];
		//i는 0부터 i가 배열의 크기보다 작을 때까지 1씩 증가
		//=> i는 0부터 i가 배열의 크기보다 작을 때까지
		for(int i = 0; i<arr.length; ) {
			//랜덤한 수를 배열 i번지에 저장
			//=>랜덤한 수를 r에 저장
			int r = random(min, max);
			//배열에 r이 없으면 [배열 i번지에 r을 저장한 후, i를 1증가]
			if(!contains(arr, r)) {
				arr[i] = r;
				i++;
			}
		}
		return arr;
	}
	public static int random(int min, int max) {
		if(min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max - min + 1) + min);
	}
	public static boolean contains(int []arr, int num) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		for(int tmp : arr) {
			if(num == tmp) {
				return true;
			}
		}
		return false;
	}
}
