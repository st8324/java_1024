package day05;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* - 배열 선언 방법
		 * 자료형 배열명[];
		 * 자료형 []배열명;
		 * */
		int arr1[], arr2;	//arr1: 배열, arr2: int arr2=>변수
		int [] arr3, arr4;	//arr3: 배열, arr4: int[]arr4 =>배열
		/* - 배열 선언과 동시에 할당
		 * 자료형 배열명 [] = new 자료형[크기];
		 * 자료형 [] 배열명 = new 자료형[크기];
		 * 할당된 배열의 각 번지는 기본값으로 초기화가 된다.
		 * */
		int arr5 [] = new int [5];
		int [] arr6 = new int [5];
		
		/* 배열의 번지를 이용한 사용 방법
		 * - 배열명[번지]를 이용하여 변수처럼 활용*/
		arr6[0] = 1;
		System.out.println(arr6[0]);
		//arr6[5] = 1;//ArrayIndexOutOfBoundsException 발생, 5개짜리 배열은 4번지까지 가능
		
	}

}
