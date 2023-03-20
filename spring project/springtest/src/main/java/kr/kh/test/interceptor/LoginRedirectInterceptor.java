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

public class LoginRedirectInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		/* LoginRedirectInterceptor는 기능을 위해 로그인 페이지로 온 경우 
		 * 로그인을 하고 이전 페이지로 이동하기 위한 인터셉터
		 * 조건이 로그인이 되어 있어야 하고, 이전 URL이 있어야 함.
		 * */
		HttpSession session = request.getSession();
		
		MemberVO user = (MemberVO)session.getAttribute("user");
		//로그인 여부 확인
		if(user == null) 
			return true;
		
		String prevUrl = (String)session.getAttribute("prevURL");
		//이전 URL이 있는지 확인
		if(prevUrl == null)
			return true;
		//이전 URL로 보내는 작업
		response.sendRedirect(prevUrl);
		session.removeAttribute("prevURL");
		return false;
	}
}
