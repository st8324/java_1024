package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardTypeVO> getBoardType(int authority);

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	ArrayList<BoardVO> getBoardList();

}
