package kr.kh.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Integer num) {
		String name = memberService.selectMemberName(num);
		System.out.println(name);
		mv.setViewName("/main/home");
		return mv;
	}
}
