package db.day3.service;

import db.day3.DBConnector;
import db.day3.dao.StudentMapper;

public class StudentServiceImp implements StudentService {

	private StudentMapper studentDao;
	
	public StudentServiceImp(DBConnector dbConnector) {
		studentDao = new StudentMapper(dbConnector);
	}

}
