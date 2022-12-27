package db.day3.dao;

import java.sql.SQLException;

import db.day3.DBConnector;
import db.day3.vo.StudentVO;

public class StudentMapper implements StudentDAO {

	private DBConnector dbConnector;
	
	public StudentMapper(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public void insertStudent(StudentVO std) {
		String sql = "insert into student(st_num, st_name, st_semester, st_state, "
				+ "st_pr_num) values(?, ?, ?, ?, ?)";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, std.getSt_num());
			dbConnector.pstmt.setString(2, std.getSt_name());
			dbConnector.pstmt.setInt(3, std.getSt_semester());
			dbConnector.pstmt.setString(4, std.getSt_state());
			dbConnector.pstmt.setString(5, std.getSt_pr_num());
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) 
				System.out.println("학생 정보 추가 실패");
			else
				System.out.println("학생 정보 추가 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateStudent(StudentVO std) {
		String sql = "update student set "
			+ " st_name = ?, st_semester = ?,"
			+ " st_state = ?, st_pr_num = ? "
			+ " where st_num = ?";
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(5, std.getSt_num());
			dbConnector.pstmt.setString(1, std.getSt_name());
			dbConnector.pstmt.setInt(2, std.getSt_semester());
			dbConnector.pstmt.setString(3, std.getSt_state());
			dbConnector.pstmt.setString(4, std.getSt_pr_num());
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) 
				System.out.println("학생 정보 수정 실패");
			else
				System.out.println("학생 정보 수정 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
