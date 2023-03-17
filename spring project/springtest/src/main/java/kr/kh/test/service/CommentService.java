package kr.kh.test.service;

import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

public interface CommentService {

	boolean insertComment(CommentVO comment, MemberVO user);

}
