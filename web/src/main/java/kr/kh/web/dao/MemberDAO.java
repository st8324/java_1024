package kr.kh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< Updated upstream
import java.sql.SQLException;
=======
>>>>>>> Stashed changes

import kr.kh.web.common.JDBCConnector;
import kr.kh.web.vo.MemberVO;

public class MemberDAO {
	Connection con = JDBCConnector.getInstance();
	PreparedStatement pstmt;
<<<<<<< Updated upstream
	public boolean insertMember(MemberVO member) {
		String sql = "insert into member(id, pw) values(?,?)";
=======
	
	public boolean insertMember(MemberVO member) {
		String sql = "insert into member(id,pw) values(?,?)";
>>>>>>> Stashed changes
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			int count = pstmt.executeUpdate();
<<<<<<< Updated upstream
			if(count == 0) 
				return false;
			else
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
=======
			if(count != 0)
				return true;
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("예외 발생");
		}
		return false;
		
	}

>>>>>>> Stashed changes
}
