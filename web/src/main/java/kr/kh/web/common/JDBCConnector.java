package kr.kh.web.common;


import java.sql.Connection;
import java.sql.DriverManager;

//싱글톤 클래스로 생성
//클래스로 객체를 직접 생성하지 못하고, getInstance() 메소드로 만들어진 객체를 가져오는 클래스
//객체가 1개만 존재
public class JDBCConnector {
	private static Connection conn;
	
	public static Connection getInstance() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url ="jdbc:mysql://localhost:3306/web?useSSL=false&serverTimezone=Asia/Seoul";
			String userName = "root";
			String password = "root";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
			return conn;
		}catch(Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	
	public static void close() {
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}catch(Exception e) {

				e.printStackTrace();
			}
		}
	}
}
