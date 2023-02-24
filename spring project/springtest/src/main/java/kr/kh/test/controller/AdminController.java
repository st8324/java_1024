package kr.kh.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.AdminService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.BoardTypeVO;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/admin/board/type/list")
	public ModelAndView adminBoardTypeList(ModelAndView mv) {
		ArrayList<BoardTypeVO> boardTypeList = adminService.getBoardTypeListAll();
		mv.addObject("btList", boardTypeList);
		mv.setViewName("/admin/boardTypeList");
		return mv;
	}
	@RequestMapping(value = "/admin/board/type/insert", 
			method=RequestMethod.POST)
	public ModelAndView adminBoardTypeInsert(ModelAndView mv,
			BoardTypeVO bt, 
			HttpServletResponse response,
			HttpServletRequest request) {
		//게시판 정보 확인하는 작업
		//System.out.println(bt);
		//서비스에게 게시판 정보를 주면서 등록하라고 요청한 후 등록 여부를 알려줌
		boolean isInsert = adminService.insertBoardType(bt);
		if(isInsert) {
			//화면에 게시판 등록 성공 메세지 전송
			MessageUtils.alertAndMovePage(
				response, 
				"새 게시판을 추가했습니다.", 
				request.getContextPath(), 
				"/admin/board/type/list");
		}else {
			//화면에 게시판 등록 실패 메세지 전송
			MessageUtils.alertAndMovePage(
					response, 
					"새 게시판을 추가하지 못 했습니다.", 
					request.getContextPath(), 
					"/admin/board/type/list");
		}
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	
	@RequestMapping(value = "/admin/board/type/update", 
			method=RequestMethod.POST)
	public ModelAndView adminBoardTypeUpdate(ModelAndView mv,
			BoardTypeVO bt, 
			HttpServletResponse response,
			HttpServletRequest request) {
		//게시판 정보 확인하는 작업
		//System.out.println(bt);
		//서비스에게 게시판 정보를 주면서 등록하라고 요청한 후 등록 여부를 알려줌
		boolean isUpdate = adminService.updateBoardType(bt);
		if(isUpdate) {
			//화면에 게시판 수정 성공 메세지 전송
			MessageUtils.alertAndMovePage(
				response, 
				"게시판을 수정했습니다.", 
				request.getContextPath(), 
				"/admin/board/type/list");
		}else {
			//화면에 게시판 수정 실패 메세지 전송
			MessageUtils.alertAndMovePage(
					response, 
					"게시판을 수정하지 못 했습니다.", 
					request.getContextPath(), 
					"/admin/board/type/list");
		}
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
	
	@RequestMapping(value = "/admin/board/type/delete", 
			method=RequestMethod.GET)
	public ModelAndView adminBoardTypeDelete(ModelAndView mv,
			Integer bt_num, 
			HttpServletResponse response,
			HttpServletRequest request) {
		//게시판 번호 정보 확인하는 작업
		System.out.println(bt_num);
		//서비스에게 게시판 번호를 주면서 삭제하라고 요청한 후 삭제 여부를 알려줌
		boolean isDelete = adminService.deleteBoardType(bt_num);
		if(isDelete) {
			//화면에 게시판 삭제 성공 메세지 전송
			MessageUtils.alertAndMovePage(
				response, 
				"게시판을 삭제했습니다.", 
				request.getContextPath(), 
				"/admin/board/type/list");
		}else {
			//화면에 게시판 삭제 실패 메세지 전송
			MessageUtils.alertAndMovePage(
					response, 
					"이미 삭제된 게시판이거나 없는 게시판입니다.", 
					request.getContextPath(), 
					"/admin/board/type/list");
		}
		
		mv.setViewName("redirect:/admin/board/type/list");
		return mv;
	}
}
