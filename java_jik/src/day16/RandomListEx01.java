package day16;

import java.util.ArrayList;
import java.util.HashSet;

public class RandomListEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int maxCount = 3, min = 1, max = 9;
		
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < maxCount) {
			int r = (int)(Math.random()*(max - min + 1) + min);
			set.add(r);
		}
		list.addAll(set);
		System.out.println(list);
	}

}
