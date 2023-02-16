package kr.kh.spring.dao;

import java.util.ArrayList;

import kr.kh.spring.vo.BoardTypeVO;

public interface BoardDAO {

	ArrayList<BoardTypeVO> selectAllBoardType();

}
