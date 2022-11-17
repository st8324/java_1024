package day19;

import lombok.Data;

@Data
public class Student {
	private int grade;
	private int classNum;
	private int num;
	private String name;
	private int kor, eng, math;

	public Student(int grade, int classNum, int num, String name) {
		this(grade, classNum, num, name, 0, 0, 0);
	}

	public Student(int grade, int classNum, int num, String name, int kor, int eng, int math) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
}
