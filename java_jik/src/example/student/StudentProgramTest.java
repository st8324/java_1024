package example.student;

import java.util.Scanner;

public class StudentProgramTest {

	public static void main(String[] args) {
		StudentManager sm = new StudentManager(new Scanner(System.in), 30);
		sm.run();
	}

}
