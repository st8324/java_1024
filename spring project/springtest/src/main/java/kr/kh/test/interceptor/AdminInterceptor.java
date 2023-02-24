package kr.kh.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.test.vo.MemberVO;

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
			//가려던 url 컨트롤러 가지 말고
			//리다이렉트로 바로 이동하는 의미
			return false;
		}
		return true;
	}
}
