package day14;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx01 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(0,10);
		list.remove(1);
		list.remove((Integer)10);
		System.out.println(list);
		System.out.println("1이 있나요? " + list.contains(1));
		System.out.println("1이 어디에 있나요? " + list.indexOf(1) + "번지");
		System.out.println("1번지에 있는 값: " + list.get(1));
		
		for(int i = 0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		for(Integer tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
		
	}

}
