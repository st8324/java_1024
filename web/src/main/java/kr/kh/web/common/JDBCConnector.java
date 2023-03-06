package kr.kh.web.common;

<<<<<<< Updated upstream
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCConnector {
	private static Connection conn;
	private JDBCConnector() {}
	public static Connection getInstance() {
		Properties props = new Properties();
		String path = "C:\\Users\\staju\\eclipse-workspace\\web\\src\\main\\webapp\\properties\\database.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(path);
			props.load(fis);
			String driver = props.getProperty("driver").trim();
			String url = props.getProperty("url").trim();
			String username = props.getProperty("username").trim();
			String password = props.getProperty("password").trim();
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("연경성공");
			return conn;
		} catch (Exception e) {
			// TODO Auto-generated catch block
=======
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
>>>>>>> Stashed changes
			e.printStackTrace();
		}
		return null;
	}
<<<<<<< Updated upstream
	public static void close() {
		
		if( conn != null ) {
			try {
				if( !conn.isClosed() ) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
=======
	
	public static void close() {
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			}catch(Exception e) {
>>>>>>> Stashed changes
				e.printStackTrace();
			}
		}
	}
}
