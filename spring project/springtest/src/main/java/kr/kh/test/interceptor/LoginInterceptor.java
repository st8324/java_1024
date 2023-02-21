package kr.kh.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.test.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter  {
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		//컨트롤러가 ModelAndView에 담아서 보낸 user 정보를 가져오는 작업
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	    //MemberVO user =  (MemberVO)modelAndView.getModelMap().get("user");
	    //회원 정보가 있으면
	    if(user != null) {
	    	//세션에 회원 정보를 추가
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	    }
	}

}
