package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	
	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardTypeVO> getBoardType(int authority) {
		return boardDao.selectAllBoardType(authority);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user) {
		//회원 정보가 없으면
		if(user == null)
			return false;
		//게시글에 빠진 항목이 있으면 false를 리턴
		if(!checkBoard(board))
			return false;
		board.setBo_me_id(user.getMe_id());
		
		//게시글 등록
		boardDao.insertBoard(board);
		//첨부파일 등록
		
		return true;
	}
	private boolean checkBoard(BoardVO board) {
		//게시글이 없거나, 게시글 제목이 비어있거나, 내용이 비어있으면
		if(board == null || 
			board.getBo_title() == null|| 
			board.getBo_title().trim().length() == 0 ||
			board.getBo_content() == null || 
			board.getBo_content().trim().length() == 0)
			return false;
		
		return true;
	}

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}
}
