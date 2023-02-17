package kr.kh.spring.service;

import java.util.ArrayList;

import kr.kh.spring.vo.BoardTypeVO;

public interface BoardService {

	ArrayList<BoardTypeVO> getBoardType(int authority);

}
