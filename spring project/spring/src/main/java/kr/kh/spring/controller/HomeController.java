package kr.kh.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.spring.pagination.Criteria;
import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.BoardListDTO;
import kr.kh.spring.vo.MemberOKVO;
import kr.kh.spring.vo.MemberVO;


@Controller
public class HomeController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/main/home");
		return mv;
	}
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public ModelAndView signup(ModelAndView mv) {
		mv.setViewName("/member/signup");
		return mv;
	}
	@RequestMapping(value = "/signup", method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv, MemberVO member) {
		boolean isSignup = memberService.signup(member);
		if(isSignup) {
			
			//아이디가 주어지면 주어진 아이디의 인증 번호를 발급하고, 
			//발급한 인증 번호를 DB에 저장하고, 이메일로 인증 번호가 있는 링크를 전송하는 기능
			memberService.emailAuthentication(member.getMe_id(), member.getMe_email());
			mv.setViewName("redirect:/");
		}else {
			mv.setViewName("redirect:/signup");
		}
		return mv;
	}
	
	@RequestMapping(value = "/email", method=RequestMethod.GET)
	public ModelAndView emial(ModelAndView mv,MemberOKVO mok) {
		if(memberService.emailAuthenticationConfirm(mok)) {
			
		}else {
			
		}
		
		mv.setViewName("redirect:/");
		return mv;
	}
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public ModelAndView login(ModelAndView mv, HttpServletRequest request) {
		String url = request.getHeader("Referer");
		//다른 URL을 통해 로그인페이지로 온 경우
		//(단, 로그인 실패로 인해서 login post에서 온 경우는 제외)
		if(url != null && !url.contains("login")) {
			request.getSession().setAttribute("prevURL", url);
		}
		mv.setViewName("/member/login");
		return mv;
	}
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv, MemberVO member) {
		MemberVO user = memberService.login(member);
		mv.addObject("user", user);
		if(user != null) { 
			mv.setViewName("redirect:/");
			//자동로그인 체크여부는 화면에서 가져오는 거지 DB에서 가져오는게 아님
			//user는 DB에서 가져온 회원 정보라 자동 로그인 여부를 알 수가 없음
			//그래서 화면에서 가져온 member에 있는 자동 로그인 여부를 user에 수정
			user.setAutoLogin(member.isAutoLogin());
		}else
			mv.setViewName("redirect:/login");
		return mv;
	}
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public ModelAndView logout(ModelAndView mv, 
			HttpSession session,
			HttpServletResponse response) throws IOException {
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그아웃 되었습니다.');location.href='/spring/'</script>");
			out.flush();
		}
		//세션에 있는 회원 정보를 삭제
		session.removeAttribute("user");
		user.setMe_session_limit(null);
		memberService.updateMemberBySession(user);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	
	@RequestMapping(value = "/ex1")
	public ModelAndView ex1(ModelAndView mv,String name, Integer age) {
		System.out.println("예제1 - 화면에서 전달한 이름 : " + name);
		System.out.println("예제1 - 화면에서 전달한 나이 : " + age);
		mv.setViewName("/main/ex1");
		return mv;
	}
	@RequestMapping(value = "/ex2")
	public ModelAndView ex2(ModelAndView mv,String name, Integer age) {
		System.out.println("예제2 - 화면에서 전달한 이름 : " + name);
		System.out.println("예제2 - 화면에서 전달한 나이 : " + age);
		mv.setViewName("/main/ex2");
		return mv;
	}
	@RequestMapping(value = "/ex3")
	public ModelAndView ex3(ModelAndView mv) {
		mv.setViewName("/main/ex3");
		return mv;
	}
	@RequestMapping(value = "/ex3/{name}/{age}")
	public ModelAndView exNameAge3(ModelAndView mv,
			@PathVariable("name")String name,
			@PathVariable("age")int age) {
		System.out.println("예제3 - 화면에서 전달한 이름 : " + name);
		System.out.println("예제3 - 화면에서 전달한 나이 : " + age);
		mv.setViewName("/main/ex3");
		return mv;
	}
	@RequestMapping(value = "/ex4")
	public ModelAndView ex4(ModelAndView mv) {
		/* 서버에서 화면으로 이름과 나이를 전송
		 * - 화면에서 호출할 이름(변수명)과 값을 지정
		 * - addObject메소드를 통해서
		 * */
		mv.addObject("name", "둘리");
		mv.addObject("age", 10000);
		mv.setViewName("/main/ex4");
		return mv;
	}
	@ResponseBody
	@RequestMapping(value = "/check/id", method=RequestMethod.POST)
	public Map<String, Object> boardLike(@RequestBody MemberVO user) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean res = memberService.checkId(user);
		map.put("res", res);
		return map;
	}
	
	@RequestMapping(value = "/ex6")
	public ModelAndView ex6(ModelAndView mv) {
		mv.setViewName("/main/ex6");
		return mv;
	}
	@RequestMapping(value = "/ex6",method=RequestMethod.POST)
	public ModelAndView ex6Post(ModelAndView mv, BoardListDTO list) {
		System.out.println(list);
		mv.setViewName("redirect:/ex6");
		return mv;
	}
	@RequestMapping(value = "/ex7",method=RequestMethod.GET)
	public ModelAndView ex7(ModelAndView mv, Criteria cri, MemberVO member) {
		System.out.println("ex7 : " +member);
		mv.setViewName("/main/ex7");
		return mv;
	}
	@RequestMapping(value = "/ex8",method=RequestMethod.GET)
	public ModelAndView ex8(ModelAndView mv, MemberVO member) {
		System.out.println("ex8 : " + member);
		mv.setViewName("forward:/ex9");
		return mv;
	}
	@RequestMapping(value = "/ex9",method=RequestMethod.GET)
	public ModelAndView ex9(ModelAndView mv, MemberVO member) {
		System.out.println("ex9 : " +member);
		mv.setViewName("redirect:/ex7");
		return mv;
	}
}
