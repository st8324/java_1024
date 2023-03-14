package kr.kh.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.spring.service.BoardService;
import kr.kh.spring.vo.CommentVO;

@RestController
public class CommentController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/comment/insert", method=RequestMethod.POST)
	public Map<String, Object> boardList(@RequestBody CommentVO comment) {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(comment);
		return map;
	}
}
