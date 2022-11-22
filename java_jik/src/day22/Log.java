package day22;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Log {
	private ArrayList<StudentLog> slogs = new ArrayList<StudentLog>();
	private String date;
	
	public Log(ArrayList<Student> stds, String date) {
		this.date = date;
		for(Student std : stds) {
			StudentLog slog = new StudentLog(std, null);
			slogs.add(slog);
		}
	}
}
