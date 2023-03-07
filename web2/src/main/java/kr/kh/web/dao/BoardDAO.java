package kr.kh.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.kh.web.common.JDBCConnector;
import kr.kh.web.vo.BoardVO;
import kr.kh.web.vo.MemberVO;

public class BoardDAO {
	Connection con = JDBCConnector.getInstance();
	PreparedStatement pstmt;
	
	public boolean insertBoard(BoardVO board) {
		String sql = 
			"insert into board(board_num, board_title, board_content, board_writer) "
			+ " select ifnull(max(board_num), 0) + 1, ?, ?, ? from board";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_title());
			pstmt.setString(2, board.getBoard_content());
			pstmt.setString(3, board.getBoard_writer());
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

	public boolean updateBoard(BoardVO board) {
		String sql = 
				"update board set board_title = ?, board_content = ?"
				+ " where board_num = ?";
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBoard_title());
				pstmt.setString(2, board.getBoard_content());
				pstmt.setInt(3, board.getBoard_num());
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
