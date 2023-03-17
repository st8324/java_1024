package kr.kh.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.CommentVO;

public interface CommentDAO {

	int insertComment(@Param("comment")CommentVO comment);

}
