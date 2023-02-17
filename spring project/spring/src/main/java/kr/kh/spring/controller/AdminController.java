package kr.kh.spring.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.service.AdminService;
import kr.kh.spring.vo.BoardTypeVO;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value="/admin/board/type/list")
	public ModelAndView boardTypeList(ModelAndView mv) {
		//admin서비스에게 모든 게시글 타입을 가져올라고 요청
		ArrayList<BoardTypeVO> list = adminService.getBoardType();
		
		mv.addObject("list", list);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}
	
	@RequestMapping(value="/admin/board/type/insert", method=RequestMethod.POST)
	public ModelAndView boardTypeInsert(ModelAndView mv, BoardTypeVO bt) {
		boolean res = adminService.insertBoardType(bt);
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	@RequestMapping(value="/admin/board/type/update", method=RequestMethod.POST)
	public ModelAndView boardTypeUpdate(ModelAndView mv, BoardTypeVO bt) {
		boolean res = adminService.updateBoardType(bt);
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	@RequestMapping(value="/admin/board/type/delete", method=RequestMethod.POST)
	public ModelAndView boardTypeDelete(ModelAndView mv, BoardTypeVO bt) {
		boolean res = adminService.deleteBoardType(bt.getBt_num());
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
}
