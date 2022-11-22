package day22;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Attendance {
	private ArrayList<Student> stds = new ArrayList<Student>();
	private ArrayList<Log> logs = new ArrayList<Log>();
	
}
