package kr.kh.test.service;

import java.util.ArrayList;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

	ArrayList<CommentVO> getCommentList(int bo_num, Criteria cri);

	int getTotalCountCommentList(int bo_num);

	int deleteComment(CommentVO comment, MemberVO user);

}
