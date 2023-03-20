package kr.kh.test.controller;

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
		System.out.println(cri);
		System.out.println(bo_num);
		return map;
	}
}
