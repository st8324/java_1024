package kr.kh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.kh.web.common.JDBCConnector;
import kr.kh.web.vo.MemberVO;

public class TestDAO {
	Connection con = JDBCConnector.getInstance();
	PreparedStatement pstmt;
	public boolean insertMember(MemberVO member) {
		String sql = "insert into member(id, pw) values(?,?)";
		
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
	public ArrayList<MemberVO> selectMemberList(){
		String sql = "select * from member";
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
	        	String pw = rs.getString(2);
	        	MemberVO member = new MemberVO(id, pw);
	        	list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
