package db.day1;

import java.sql.*;
import java.util.ArrayList;

import lombok.Data;

public class DBTest1 {

	static Statement stmt = null;
	static ResultSet rs = null;
	
	public static void main(String[] args) {
		Connection con = null;
		 /* mysql : DBMS
         * localhost : 내부 로컬 주소-> 프로그램이 실행되는 서버와 DB가 같은 PC에 있는 경우
         * university : 데이터베이스명 
         */
		String url = "jdbc:mysql://localhost/university";
        String id = "root";
        String pw = "root";
        ArrayList<Student1> list = null;
        con = connect(url, id, pw);
        
        try {
			stmt = con.createStatement();
			list = selectAllStduent(con);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        
        connectClose(con);
	}
	
	public static Connection connect(String url,String id,String pw) {
		Connection con = null;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
			System.out.println("[연결 성공]");
		}
		catch(ClassNotFoundException e){
		    System.out.println("[드라이버 로딩 실패]");
		}
		catch(SQLException e){
		    System.out.println("[에러: " + e +"]");
		}
		return con;
	}
	
	public static void connectClose(Connection con) {
		try{
            if( con != null && !con.isClosed()){
                con.close();
                System.out.println("[연결 해제]");
            }
        }
        catch( SQLException e){
            e.printStackTrace();
        }
	}
	
	public static ArrayList<Student1> selectAllStduent(Connection con) throws SQLException {
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
}
@Data
class Student1{
	private String st_num;
	private String st_name;
	private int st_semester;
	private String st_state;
	private String st_pr_num;

	public Student1(String st_num, String st_name, int st_semester, String st_state, String st_pr_num) {
		this.st_num = st_num;
		this.st_name = st_name;
		this.st_semester = st_semester;
		this.st_state = st_state;
		this.st_pr_num = st_pr_num;
	}
	
}
