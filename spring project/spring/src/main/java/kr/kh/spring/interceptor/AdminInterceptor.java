package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.vo.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter  {
	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(user == null || user.getMe_authority() < 9) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		return true;
	}
}
