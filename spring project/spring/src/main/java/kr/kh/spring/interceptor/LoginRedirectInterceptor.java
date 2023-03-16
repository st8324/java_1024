package kr.kh.spring.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.vo.MemberVO;

public class LoginRedirectInterceptor extends HandlerInterceptorAdapter  {
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user != null) {
			String url = (String)session.getAttribute("prevURL");
			if(url != null) {
				response.sendRedirect(url);
				session.removeAttribute("prevURL");
				
				return false;
			}
		}
		return true;
		/* 인터셉터에서 preHandle에 return값이 true이면 가려던 URL을 들림
		 * return 값이 false이면 가려던 URL을 가지 않고 response에 리다이렉트할
		 * URL이 있으면 해당 URL로 이동하고 없으면 빈 화면이 나옴(아무것도 없는)
		 * */
	}
}
