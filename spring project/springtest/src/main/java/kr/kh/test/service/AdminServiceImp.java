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
		if(!checkBoardType(bt))
			return false;
		//다오에게 게시판 정보를 주면서 DB에 추가하라고 요청한 후, 성공 여부를 가져옴
		int res = boardDao.insertBoardType(bt);
		return res != 0;
		//return boardDao.insertBoardType(bt) != 0;
	}

	@Override
	public boolean updateBoardType(BoardTypeVO bt) {
		//매개변수 체크
		if(!checkBoardType(bt))
			return false;
		System.out.println("게시판 타입 체크 완료");
		if(bt.getBt_num() < 1)
			return false;
		System.out.println("게시판 번호 체크 완료");
		//다오에게 게시판 정보를 주면서 수정하라고 요청한 후 수정여부를 이용하여 리턴함
		return boardDao.updateBoardType(bt) != 0;
	}
	//BoardTypeVO 체크(bt_num제외)
	private boolean checkBoardType(BoardTypeVO bt) {
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
		
		//게시판명 체크(null 체크 또는 게시판명이 빈공백으로 되어 있는 경우)
		//"   abc   \t\n".trim() => "abc"
		if(bt.getBt_name() == null || 
			bt.getBt_name().trim().length() == 0)
			return false;
		//게시판명 중복 체크
		//다오에게 게시판명을 주면서 게시판정보를 가져오라고 시킴
		BoardTypeVO dbBt = 
			boardDao.selectBoardTypeByName(bt.getBt_name());

		//가져온 게시판이 있는경우
		//1. 서로 다른 게시판인데 이름이 중복되는 경우(중복이므로 false)
		//2. 같은 게시판인 경우(자기자신이므로 true)
		if(dbBt != null && bt.getBt_num() != dbBt.getBt_num())
			return false;
		return true;
	}

	@Override
	public boolean deleteBoardType(Integer bt_num) {
		//번호 체크
		if(bt_num == null || bt_num < 1)
			return false;
		//다오에게 게시판 번호 주면서 삭제 요청
		return boardDao.deleteBoardType(bt_num);
	}
}
