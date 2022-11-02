package day08;

public class MehotdArguments {
	public static void main(String[] args) {
		/* 매개변수의 개수를 다양하게 하고 싶을 때 가변 인자를 사용
		 * 매개변수에 자료형... 배열명 => 메소드에서 배열처럼 사용
		 * 가변인자는 반드시 매개변수 마지막에 사용
		 * */
		System.out.println(sum());
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3));
	}
	public static int sum(int ...nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		for(int num : nums) {
			sum += num;
		}
		return sum;
	}
	public static int sum(int num) {
		return num;
	}
	public static void score(int grade, int classNum, int num, String name, int ...score ) {
		
	}
}
