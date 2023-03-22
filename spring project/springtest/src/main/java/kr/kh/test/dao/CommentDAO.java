package kr.kh.test.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.CommentVO;

public interface CommentDAO {

	int insertComment(@Param("comment")CommentVO comment);

	ArrayList<CommentVO> selectCommentList(@Param("co_bo_num")int bo_num, @Param("cri")Criteria cri);

	int selectTotalCountCommentList(@Param("co_bo_num")int bo_num);

	CommentVO selectComment(@Param("co_num")int co_num);

	int deleteComment(@Param("co_num")int co_num);

	int updateComment(@Param("comment")CommentVO comment);

}
