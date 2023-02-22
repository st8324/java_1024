package kr.kh.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.test.service.MemberService;
import kr.kh.test.utils.MessageUtils;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	String contextPath = "/test";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView mv, Integer num) {
		String name = memberService.selectMemberName(num);
		mv.setViewName("/main/home");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member,
			HttpServletResponse response) {	
		boolean res = memberService.signup(member);
		if(res) {
			//성공했다고 알림 메세지
			MessageUtils.alertAndMovePage(response, "회원가입에 성공했습니다.", 
					contextPath, "/");
			mv.setViewName("redirect:/");
		}else {
			//실패했다고 알림 메세지
			MessageUtils.alertAndMovePage(response, "회원가입에 실패했습니다.", 
					contextPath, "/signup");
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv,MemberVO member,
			HttpServletResponse response) {
		MemberVO user = memberService.login(member);
		//인증한 회원들만 로그인 하도록
		if(user != null && user.getMe_authority() > 0) {
			mv.addObject("user", user);
			mv.setViewName("redirect:/");
			MessageUtils.alertAndMovePage(response, "로그인에 성공했습니다.", 
					contextPath, "/");
		}else {
			if(user != null) {
				//인증 안된 회원이라고 알려주는 메세지
				MessageUtils.alertAndMovePage(response, "이메일 인증을 완료해야 로그인이 가능합니다.", 
						contextPath, "/login");
			}else {
				MessageUtils.alertAndMovePage(response, "로그인에 실패했습니다.", 
						contextPath, "/login");
			}
			mv.setViewName("redirect:/login");
		}
		return mv;
	}
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ModelAndView logoutPost(ModelAndView mv, HttpSession session, 
			HttpServletResponse response) {
		if(session != null) {
			session.removeAttribute("user");
			MessageUtils.alertAndMovePage(response, "로그아웃에 성공했습니다.", 
					contextPath, "/");
		}
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@RequestMapping(value = "/email/authentication", method = RequestMethod.GET)
	public ModelAndView emailAuthentication(ModelAndView mv, MemberOKVO mok, 
			HttpServletResponse response) {
		boolean res = memberService.emailAuthentication(mok);
		if(res) {
			//인증 성공 메세지 
			MessageUtils.alertAndMovePage(response, "이메일 인증에 성공했습니다.", 
					contextPath, "/");
		}else {
			//인증 실패 메세지
			MessageUtils.alertAndMovePage(response, "이메일 인증에 실패했습니다.", 
					contextPath, "/");
		}
		mv.setViewName("redirect:/");
		return mv;
	}
}
