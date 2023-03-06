package kr.kh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.kh.web.common.JDBCConnector;
import kr.kh.web.vo.MemberVO;

public class MemberDAO {
	Connection con = JDBCConnector.getInstance();
	PreparedStatement pstmt;
	
	public boolean insertMember(MemberVO member) {
		String sql = "insert into member(id,pw) values(?,?)";

		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			int count = pstmt.executeUpdate();

			if(count == 0) 
				return false;
			else
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
