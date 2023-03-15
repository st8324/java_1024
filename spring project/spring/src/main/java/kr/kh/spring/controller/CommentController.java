package kr.kh.spring.controller;

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

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.pagination.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.vo.CommentVO;
import kr.kh.spring.vo.MemberVO;

@RestController
public class CommentController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/comment/insert", method=RequestMethod.POST)
	public Map<String, Object> commentInsert(@RequestBody CommentVO comment,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.insertComment(comment, user);
		map.put("result", res);
		return map;
	}
	@RequestMapping(value = "/comment/list/{co_bo_num}", method=RequestMethod.POST)
	public Map<String, Object> commentList(@RequestBody Criteria cri,
			@PathVariable("co_bo_num") int co_bo_num) {
		Map<String, Object> map = new HashMap<String, Object>();

		ArrayList<CommentVO> list = boardService.getCommentList(cri, co_bo_num);
		//PageMaker
		int totalCount = boardService.getTotalCountCommentList(co_bo_num);
		PageMaker pm = new PageMaker(totalCount, 5, cri);
		map.put("list", list);
		map.put("pm", pm);
		return map;
	}
	@RequestMapping(value = "/comment/delete", method=RequestMethod.POST)
	public Map<String, Object> commentDelete(@RequestBody CommentVO comment,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.deleteComment(comment, user);
		map.put("result", res);
		return map;
	}
	@RequestMapping(value = "/comment/update", method=RequestMethod.POST)
	public Map<String, Object> commentUpdate(@RequestBody CommentVO comment,
			HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		MemberVO user = (MemberVO) session.getAttribute("user");
		boolean res = boardService.updateComment(comment, user);
		map.put("result", res);
		return map;
	}
}
