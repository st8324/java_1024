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
}
