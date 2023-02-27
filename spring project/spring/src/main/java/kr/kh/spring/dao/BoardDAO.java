package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;

public interface BoardDAO {

	ArrayList<BoardTypeVO> selectAllBoardType(@Param("authority")int authority);

	boolean insertBoardType(@Param("bt")BoardTypeVO bt);

	boolean updateBoardType(@Param("bt")BoardTypeVO bt);

	boolean deleteBoardType(@Param("bt_num")int bt_num);

	void insertBoard(@Param("bo")BoardVO board);

	ArrayList<BoardVO> selectBoardList();

	void insertFile(@Param("file")FileVO fileVo);

	BoardVO selectBoard(@Param("bo_num")int bo_num);

	ArrayList<FileVO> selectFileList(@Param("bo_num")int bo_num);

}
