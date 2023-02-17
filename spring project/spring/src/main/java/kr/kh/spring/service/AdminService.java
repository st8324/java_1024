package kr.kh.spring.service;

import java.util.ArrayList;

import kr.kh.spring.vo.BoardTypeVO;

public interface AdminService {

	ArrayList<BoardTypeVO> getBoardType();

	boolean insertBoardType(BoardTypeVO bt);

	boolean updateBoardType(BoardTypeVO bt);

	boolean deleteBoardType(int bt_num);

}
