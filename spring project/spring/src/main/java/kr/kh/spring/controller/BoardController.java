package kr.kh.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.service.BoardService;
import kr.kh.spring.vo.BoardTypeVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/list", method=RequestMethod.GET)
	public ModelAndView boardList(ModelAndView mv) {
		mv.setViewName("/board/list");
		return mv;
	}
	@RequestMapping(value = "/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsert(ModelAndView mv) {
		ArrayList<BoardTypeVO> btList = boardService.getBoardType(); 
		mv.addObject("btList", btList);
		mv.setViewName("/board/insert");
		return mv;
	}
}
