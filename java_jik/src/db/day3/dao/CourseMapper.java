package db.day3.dao;

import java.sql.SQLException;

import db.day3.DBConnector;
import db.day3.vo.CourseVO;
import db.day3.vo.LectureVO;

public class CourseMapper implements CourseDAO {

	private DBConnector dbConnector;
	
	public CourseMapper(DBConnector dbConnector) {
		this.dbConnector = dbConnector;
	}

	public void insertLecture(LectureVO lecture) {
		String sql = "insert into lecture(le_name, le_schedule, le_point, "
				+ "le_class, le_year, le_term, le_pr_num) values(?,?,?,?,?,?,?)";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, lecture.getLe_name());
			dbConnector.pstmt.setString(2, lecture.getLe_schedule());
			dbConnector.pstmt.setInt(3, lecture.getLe_point());
			dbConnector.pstmt.setInt(4, lecture.getLe_class());
			dbConnector.pstmt.setInt(5, lecture.getLe_year());
			dbConnector.pstmt.setString(6, lecture.getLe_term());
			dbConnector.pstmt.setString(7, lecture.getLe_pr_num());
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) 
				System.out.println("강좌 정보 추가 실패");
			else
				System.out.println("강좌 정보 추가 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateLecture(LectureVO lecture) {
		String sql = "update lecture set le_name=?, le_schedule=?, le_point=?, "
				+ "le_class=?, le_year=?, le_term=?, le_pr_num=? "
				+ "where le_num = ?";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, lecture.getLe_name());
			dbConnector.pstmt.setString(2, lecture.getLe_schedule());
			dbConnector.pstmt.setInt(3, lecture.getLe_point());
			dbConnector.pstmt.setInt(4, lecture.getLe_class());
			dbConnector.pstmt.setInt(5, lecture.getLe_year());
			dbConnector.pstmt.setString(6, lecture.getLe_term());
			dbConnector.pstmt.setString(7, lecture.getLe_pr_num());
			dbConnector.pstmt.setInt(8, lecture.getLe_num());
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) 
				System.out.println("강좌 정보 수정 실패");
			else
				System.out.println("강좌 정보 수정 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteLecture(int le_num) {
		String sql = "delete from lecture where le_num = ?";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setInt(1, le_num);
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) 
				System.out.println("강좌 정보 삭제 실패");
			else
				System.out.println("강좌 정보 삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LectureVO selectLectureByName(String le_name, int le_class, int le_year, String le_term) {
		String sql = "select le_num, le_name, le_schedule, le_point, "
				+ "le_class, le_year, le_term, le_pr_num from lecture "
				+ "where le_name=? and le_class=? and le_year=? and le_term=?";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, le_name);
			dbConnector.pstmt.setInt(2, le_class);
			dbConnector.pstmt.setInt(3, le_year);
			dbConnector.pstmt.setString(4, le_term);
			dbConnector.rs = dbConnector.pstmt.executeQuery();
			if(dbConnector.rs.next()) {
				int le_num = dbConnector.rs.getInt(1);
				String le_schedule = dbConnector.rs.getString(3);
				int le_point = dbConnector.rs.getInt(4);
				String le_pr_num = dbConnector.rs.getString(8);
				return new LectureVO(le_num, le_name, le_schedule, le_point, 
						le_class, le_year, le_term, le_pr_num);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertCourse(CourseVO courseVO) {
		String sql = "insert into course(co_st_num, co_le_num, co_type) "
				+ "values(?,?,?)";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setString(1, courseVO.getCo_st_num());
			dbConnector.pstmt.setInt(2, courseVO.getCo_le_num());
			dbConnector.pstmt.setString(3, courseVO.getCo_type());
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("수강 신청에 실패했습니다.");
			}else {
				System.out.println("수강 신청에 성공했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deleteCourse(int le_num, String co_st_num) {
		String sql = "delete from course where co_le_num =? and co_st_num=? ";
		
		try {
			dbConnector.pstmt = dbConnector.con.prepareStatement(sql);
			dbConnector.pstmt.setInt(1, le_num);
			dbConnector.pstmt.setString(2, co_st_num);
			int count = dbConnector.pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("수강 철회에 실패했습니다.");
			}else {
				System.out.println("수강 철회에 성공했습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
