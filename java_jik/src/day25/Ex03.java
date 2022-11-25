package day25;

import java.util.ArrayList;
import java.util.Random;

public class Ex03 {

	/* 1에서 9사이의 숫자를 랜덤하게 9번 뽑아서 일렬로 출력하는 코드를 작성하세요.*/
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		int min = 1, max = 9;
		for(int i = min; i<=max; i++)
			list.add(i);
		while(list.size() != 0) {
			int r = random(0, list.size()-1);
			Integer num = list.remove(r);
			res.add(num);
		}
		System.out.println(res);
	}
	public static int random(int min, int max) {
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		Random r = new Random();
		//nextInt(정수) : 0이상 정수미만의 랜덤한 정수를 알려줌
		return r.nextInt(max - min + 1) + min;
	}
}
