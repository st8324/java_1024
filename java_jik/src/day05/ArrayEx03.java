package day05;

public class ArrayEx03 {

	public static void main(String[] args) {
		/* 5개짜리 배열을 생성하여 2부터 10까지 짝수를 차례대로 저장하고, 
		 * 출력하는 코드를 작성하세요.
		 * */
		int arr[] = new int[5];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = 2*(i+1);
			System.out.print(arr[i] + " ");
		}
	}

}
