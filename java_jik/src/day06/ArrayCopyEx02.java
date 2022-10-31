package day06;

import java.util.Arrays;


public class ArrayCopyEx02 {

	public static void main(String[] args) {
		//깊은 복사 예제
		int arr1[] = new int[] {1,2,3};
		int arr2[];
		
		//깊은 복사 예제1
		
		int tmpArr[] = new int [arr1.length];
		for(int i = 0; i<arr1.length; i++) {
			tmpArr[i] = arr1[i];
		}
		arr2 = tmpArr;
		//깊은 복사 예제2
		/*
		arr2 = new int [arr1.length];
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		*/
		//깊은 복사 예제3
		//arr2 = Arrays.copyOf(arr1, arr1.length);
		
		//arr1과 arr2 값 확인
		for(int i = 0; i<arr1.length; i++) {
			System.out.println("arr1["+i+"] = " + arr1[i] + ", arr2[" + i 
					+ "] = " + arr2[i]);
		}
		arr1[0] = 10;//arr1의 값만 10으로 변경
		System.out.println("--------------");
		//arr1과 arr2 값 확인, arr1, arr2모두 10이 출력
		for(int i = 0; i<arr1.length; i++) {
			System.out.println("arr1["+i+"] = " + arr1[i] + ", arr2[" + i 
					+ "] = " + arr2[i]);
		}

	}

}
