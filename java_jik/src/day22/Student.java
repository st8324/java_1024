package day22;

import lombok.Data;

@Data
public class Student {
	private String name;
	private String birthday;
	
	public Student(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}

	public Student(Student std) {
		this.name = std.name;
		this.birthday = std.birthday;
	}
}
