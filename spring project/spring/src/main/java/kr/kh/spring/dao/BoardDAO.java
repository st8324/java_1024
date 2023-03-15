package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.CommentVO;
import kr.kh.spring.vo.FileVO;
import kr.kh.spring.vo.LikesVO;

public interface BoardDAO {

	ArrayList<BoardTypeVO> selectAllBoardType(@Param("authority")int authority);

	boolean insertBoardType(@Param("bt")BoardTypeVO bt);

	boolean updateBoardType(@Param("bt")BoardTypeVO bt);

	boolean deleteBoardType(@Param("bt_num")int bt_num);

	void insertBoard(@Param("bo")BoardVO board);

	ArrayList<BoardVO> selectBoardList(@Param("cri")Criteria cri);

	void insertFile(@Param("file")FileVO fileVo);

	BoardVO selectBoard(@Param("bo_num")int bo_num);

	ArrayList<FileVO> selectFileList(@Param("bo_num")int bo_num);

	void updateBoardViews(@Param("bo_num")int bo_num);

	BoardTypeVO selectBoardType(@Param("bt_num")int bo_bt_num);

	LikesVO selectLikesById(@Param("li_me_id")String me_id, @Param("li_bo_num")int bo_num);

	void insertLikes(@Param("li")LikesVO likesVo);

	void updateLikes(@Param("li")LikesVO likesVo);

	int deleteBoard(@Param("bo_num")int bo_num);

	void deleteFile(@Param("file")FileVO file);

	int updateBoard(@Param("bo")BoardVO board);

	FileVO selectFile(@Param("fi_num")int fileNum);

	void updateBoardByLikes(@Param("bo_num")int bo_num);

	int selectBoardTotalCount(@Param("cri")Criteria cri);

	int insertComment(@Param("comment")CommentVO comment);

	ArrayList<CommentVO> selectCommentList(@Param("cri")Criteria cri,@Param("co_bo_num")int co_bo_num);

	int selectTotalCountCommentList(@Param("co_bo_num")int co_bo_num);

	CommentVO selectComment(@Param("co_num")int co_num);

	int deleteComment(@Param("co_num")int co_num);

	int updateComment(@Param("comment")CommentVO comment);

}
