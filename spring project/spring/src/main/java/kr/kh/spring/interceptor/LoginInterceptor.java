package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");

	    if(user != null) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	        
	        if(user.isAutoLogin()) {
	        	Cookie cookie = new Cookie("springCookie", session.getId());
	        	//1주일
	        	int time = 60 * 60 * 24 * 7;
	        	cookie.setPath("/");
	        	cookie.setMaxAge(time);
	        	response.addCookie(cookie);
	        	//DB에 me_session_id와 me_session_limit를 수정
	        	user.setMe_session_id(session.getId());
	        	//현재 시간에 1주일을 더한 날짜
	        	Date date = new Date(System.currentTimeMillis() + time * 1000);
	        	user.setMe_session_limit(date);
	        	memberService.updateMemberBySession(user);
	        }
	    }
	}
}
