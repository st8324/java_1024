package kr.kh.test.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.test.service.MemberService;
import kr.kh.test.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) 
			return true;
		
		Cookie cookie = WebUtils.getCookie(request, "testCookie");
		
		if(cookie == null)
			return true;
		
		String me_session_id = cookie.getValue();
		user = memberService.getMemberBySession(me_session_id);
		
		if(user == null)
			return true;
		
		session.setAttribute("user", user);
		
		return true;
	}
}
