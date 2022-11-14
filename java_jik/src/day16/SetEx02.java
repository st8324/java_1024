package day16;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx02 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(11);
		for(Integer tmp : set) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}
