package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{
	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardTypeVO> getBoardTypeList(MemberVO user) {
		if(user == null || user.getMe_authority() == 0)
			return null;
		return boardDao.selectBoardTypeList(user.getMe_authority());
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user, MultipartFile files) {
		if(user == null || user.getMe_authority() == 0)
			return false;
		if(board == null || 
			board.getBo_title().trim().length() == 0 ||
			board.getBo_content().trim().length() == 0 ||
			board.getBo_bt_num() == 0)
			return false;
		
		board.setBo_me_id(user.getMe_id());
		
		int isOk = boardDao.insertBoard(board);
		
		if(isOk == 0)
			return false;
		
		return true;
	}
}
