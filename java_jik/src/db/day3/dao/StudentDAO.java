package db.day3.dao;

import db.day3.vo.StudentVO;

public interface StudentDAO {

	void insertStudent(StudentVO std);
	
	void updateStudent(StudentVO std);
}
