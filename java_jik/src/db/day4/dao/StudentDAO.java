package db.day4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day4.vo.CourseVO;
import db.day4.vo.StudentVO;

public interface StudentDAO {
	
	ArrayList<StudentVO> selectAllStudent();

	int insertStudent(@Param("std")StudentVO std);

	void insertCourse(CourseVO co);
}
