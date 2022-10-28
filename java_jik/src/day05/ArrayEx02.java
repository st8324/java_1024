package day05;

public class ArrayEx02 {

	public static void main(String[] args) {
		//반복문을 활용한 배열 예제
		int arr[] = new int[5];
		//arr.length : 배열의 크기를 알려줌
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i;
			System.out.print(arr[i] + " ");
		}
		/* 향상된 for문 : 리스트나 배열에 있는 값들을 하나씩 꺼내서 반복할 때 사용
		 *  - 배열의 전체 탐색
		 *  - 번지에 있는 값을 수정하지 않을 때 사용
		 * for(자료형 변수 : 배열 또는 리스트){
		 * 		실행문;
		 * }
		 * */
		System.out.println();
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
	}

}
