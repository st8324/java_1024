package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.BoardDAO;
import kr.kh.test.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService {
	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardTypeVO> getBoardTypeListAll() {
		final int adminAuthority = 9;//관리자 권한
		return boardDao.selectBoardTypeList(adminAuthority);
	}
	
	@Override
	public boolean insertBoardType(BoardTypeVO bt) {
		//bt null 체크
		if(bt == null)
			return false;
		//게시판 타입 체크
		if(bt.getBt_type() == null ||
			(!bt.getBt_type().equals("일반") && 
			!bt.getBt_type().equals("이미지")))
			return false;
		//게시판 읽기 권한 체크
		if(bt.getBt_r_authority() != 0 && 
			bt.getBt_r_authority() != 1 &&
			bt.getBt_r_authority() != 9)
			return false;
		//게시판 쓰기 권한 체크
		if(bt.getBt_w_authority() != 1 && 
			bt.getBt_w_authority() != 9)
			return false;
		
		//게시판명 체크(null 체크)
		
		//게시판명 중복 체크
		//다오에게 게시판명을 주면서 게시판정보를 가져오라고 시킴
		//BoardTypeVO dbBt = boardDao.selectBoardTypeByName(게시판이름);
		
		//가져온 게시판 정보가 null이 아니면 false를 리턴
		
		//다오에게 게시판 정보를 주면서 DB에 추가하라고 요청한 후, 성공 여부를 가져옴
		//int res = boardDao.insertBoardType(bt);
		//return res != 0;
		return true;
	}
}
