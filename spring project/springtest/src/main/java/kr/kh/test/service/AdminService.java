package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.vo.BoardTypeVO;

public interface AdminService {

	ArrayList<BoardTypeVO> getBoardTypeListAll();
	
	boolean insertBoardType(BoardTypeVO bt);

	boolean updateBoardType(BoardTypeVO bt);

	boolean deleteBoardType(Integer bt_num);
}
