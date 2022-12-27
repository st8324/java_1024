package db.day3;

import db.day3.service.*;

public class UniversityController {

	private DBConnector dbConnector;
	private StudentServiceImp studentService;
	
	{
		String url = "jdbc:mysql://localhost/university";
		String id = "root", pw = "root";
		dbConnector = new DBConnector(url, id, pw);
		studentService = new StudentServiceImp(dbConnector);
	}
	
	public void run() {
		int menu = -1;
		int exit = 5;
		do {
			
		}while(menu != exit);
	}
	
}
