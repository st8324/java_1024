package kr.kh.web.common;

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
			e.printStackTrace();
		}
		return null;
	}
	public static void close() {
		
		if( conn != null ) {
			try {
				if( !conn.isClosed() ) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
