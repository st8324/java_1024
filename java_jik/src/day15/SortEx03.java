package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import day14.Student;

public class SortEx03 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,3));
		list.add(new Student(3,1,3));
		list.add(new Student(2,1,3));
		list.add(new Student(1,1,2));
		list.add(new Student(1,1,1));
		
		System.out.println(list);
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getGrade() != o2.getGrade()) {
					return o1.getGrade() - o2.getGrade();
				}
				if(o1.getClassNum() != o2.getClassNum()) {
					return o1.getClassNum() - o2.getClassNum();
				}
				return o1.getNum() - o2.getNum();
			}
		});
		System.out.println(list);
	}
}

