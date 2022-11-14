package day16;

import java.util.HashSet;

public class SetEx01 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(10);
		set.add(5);
		set.add(10);
		set.add(1);
		set.add(100);
		set.add(22);
		System.out.println(set);

	}

}
