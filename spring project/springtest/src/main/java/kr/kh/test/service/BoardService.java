package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.test.vo.BoardTypeVO;
import kr.kh.test.vo.BoardVO;
import kr.kh.test.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardTypeVO> getBoardTypeList(MemberVO user);

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile files);

}
