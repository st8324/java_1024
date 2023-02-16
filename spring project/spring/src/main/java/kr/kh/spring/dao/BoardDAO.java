package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.BoardTypeVO;

public interface BoardDAO {

	ArrayList<BoardTypeVO> selectAllBoardType();

	boolean insertBoardType(@Param("bt")BoardTypeVO bt);

	boolean updateBoardType(@Param("bt")BoardTypeVO bt);

}
