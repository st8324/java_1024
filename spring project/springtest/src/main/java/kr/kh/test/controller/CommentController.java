package kr.kh.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.test.pagination.Criteria;
import kr.kh.test.pagination.PageMaker;
import kr.kh.test.service.CommentService;
import kr.kh.test.vo.CommentVO;
import kr.kh.test.vo.MemberVO;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/comment/insert", method=RequestMethod.POST)
	public Map<String, Object> commentInsert(@RequestBody CommentVO comment,
		HttpSession session){
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = commentService.insertComment(comment, user);
		map.put("res", res);
		return map;
	}
	@RequestMapping(value="/comment/list/{bo_num}", method=RequestMethod.POST)
	public Map<String, Object> commentList(@RequestBody Criteria cri,
		@PathVariable("bo_num")int bo_num){
		Map<String, Object> map = new HashMap<String, Object>();
		//현재 페이지 정보를 이용하여 게시글의 댓글리스트를 가져와야함
		ArrayList<CommentVO> list = commentService.getCommentList(bo_num, cri);
		map.put("list", list);
		//페이지메이커를 생성
		int totalCount = commentService.getTotalCountCommentList(bo_num);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		map.put("pm", pm);
		return map;
	}
}
