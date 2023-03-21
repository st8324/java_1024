package kr.kh.test.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.CommentDAO;
import kr.kh.test.pagination.Criteria;
import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

@Service
public class CommnetServiceImp implements CommentService {
	
	@Autowired
	CommentDAO commentDao;

	@Override
	public boolean insertComment(CommentVO comment, MemberVO user) {
		if(comment == null || comment.getCo_content() == null ||  
				comment.getCo_content().trim().length() == 0)
			return false;
		if(user == null || user.getMe_id() == null)
			return false;
		comment.setCo_me_id(user.getMe_id());
		return commentDao.insertComment(comment) != 0;
	}

	@Override
	public ArrayList<CommentVO> getCommentList(int bo_num, Criteria cri) {
		if(cri == null)
			cri = new Criteria();
		return commentDao.selectCommentList(bo_num, cri);
	}

	@Override
	public int getTotalCountCommentList(int bo_num) {
		return commentDao.selectTotalCountCommentList(bo_num);
	}
}
