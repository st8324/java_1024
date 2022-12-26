package db.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDAOImp implements StudentDAO {

	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	
	public StudentDAOImp(Connection con) throws SQLException {
		this.con = con;
		stmt = con.createStatement();
	}
	
	public ArrayList<StudentVO1> selectAllStudent() throws SQLException{
		
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num from student";
        rs = stmt.executeQuery(sql);
        ArrayList<StudentVO1> list = new ArrayList<StudentVO1>();
        while(rs.next()) {
        	String st_num = rs.getString(1);
        	String st_name = rs.getString(2);
        	int st_semester = rs.getInt(3);
        	String st_state = rs.getString(4);
        	String st_pr_num = rs.getString(5);
        	StudentVO1 std = new StudentVO1(st_num, st_name, st_semester, st_state, st_pr_num);
        	list.add(std);
        }
        return list;
	}

	@Override
	public StudentVO1 selectStudentBySt_num(String st_num) throws SQLException {
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num "
				+ "from student where st_num = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, st_num);//1번째 ?에 변수 st_num에 있는 값으로 문자열로 바꿔주세요. 
		rs = pstmt.executeQuery();
		if(rs.next()) {
	    	String st_name = rs.getString(2);
	    	int st_semester = rs.getInt(3);
	    	String st_state = rs.getString(4);
	    	String st_pr_num = rs.getString(5);
	    	StudentVO1 std = new StudentVO1(st_num, st_name, st_semester, st_state, st_pr_num);
	    	return std;
		}
		return null;
	}

	@Override
	public boolean insertStudent(StudentVO1 std) {
		String sql = "insert into student values(?, ?, ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, std.getSt_num());
			pstmt.setString(2, std.getSt_name());
			pstmt.setInt(3, std.getSt_semester());
			pstmt.setString(4, std.getSt_state());
			pstmt.setString(5, std.getSt_pr_num());
			int count = pstmt.executeUpdate();
			if(count == 0) {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
}
