package example.db.dao;

import java.util.ArrayList;

import example.db.vo.StudentVO;
import example.db.vo.StudentVO2;

public interface StudentDAO {

	int insertStudent(StudentVO std);

	StudentVO selectStudent(String st_num);

	int updateStudent(StudentVO std);

	ArrayList<StudentVO> selectAllStudent();

	ArrayList<StudentVO2> selectAllStudent2();
	
}
