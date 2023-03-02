package kr.kh.spring.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikesVO;
import kr.kh.spring.vo.MemberVO;

public interface BoardService {

	ArrayList<BoardTypeVO> getBoardType(int authority);

	boolean insertBoard(BoardVO board, MemberVO user, MultipartFile[] files);

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(int bo_num, MemberVO user);

	ArrayList<FileVO> getFileList(int bo_num);

	int updateLikes(MemberVO user, int bo_num, int li_state);

	LikesVO getLikes(int bo_num, MemberVO user);

	boolean deleteBoard(int bo_num, MemberVO user);

	BoardVO getBoardByWriteAuthority(int bo_num, MemberVO user);

	boolean updateBoard(BoardVO board, MultipartFile[] files, int[] fileNums, MemberVO user);

	void updateBoardByLikes(int bo_num);

}
