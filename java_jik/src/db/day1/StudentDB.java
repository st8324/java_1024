package db.day1;

import java.sql.*;
import java.util.ArrayList;

public class StudentDB {
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public StudentDB(String url, String id, String pw) throws Exception {
		connect(url, id, pw);
		stmt = con.createStatement();
	}
	
	private void connect(String url,String id,String pw) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url, id, pw);
		System.out.println("[DB 연결 성공]");
	}
	
	public ArrayList<Student1> selectAllStduent() throws SQLException {
		String sql = "select st_num, st_name, st_semester, st_state, st_pr_num from student";
		rs = stmt.executeQuery(sql);
		ArrayList<Student1> list = new ArrayList<Student1>();
		while(rs.next()) {
			String st_num = rs.getString(1);
			String st_name = rs.getString(2);
			int st_semester = rs.getInt(3);
			String st_state = rs.getString(4);
			String st_pr_num = rs.getString(5);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
		}
		return list;
	}
	
	public void insertStudent(
			String st_num, String st_name, 
			int st_semester, String st_state, String st_pr_num) throws SQLException{
		String sql = "insert into student(st_num, st_name, st_semester, "+
				"st_state, st_pr_num) values(?, ?, ?, ?, ?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, st_num);
		pstmt.setString(2, st_name);
		pstmt.setInt(3, st_semester);
		pstmt.setString(4, st_state);
		pstmt.setString(5, st_pr_num);
		
		int count = pstmt.executeUpdate();
		if(count == 0) {
			System.out.println("[추가 실패]");
		}else {
			System.out.println("[추가 성공]");
		}
	}
}
