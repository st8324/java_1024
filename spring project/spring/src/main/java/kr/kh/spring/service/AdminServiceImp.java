package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.BoardDAO;
import kr.kh.spring.vo.BoardTypeVO;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public ArrayList<BoardTypeVO> getBoardType() {
		return boardDao.selectAllBoardType();
	}

	@Override
	public boolean insertBoardType(BoardTypeVO bt) {
		if(bt == null)
			return false;
		try {
			return boardDao.insertBoardType(bt);
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBoardType(BoardTypeVO bt) {
		if(bt == null)
			return false;
		return boardDao.updateBoardType(bt);
	}

}
