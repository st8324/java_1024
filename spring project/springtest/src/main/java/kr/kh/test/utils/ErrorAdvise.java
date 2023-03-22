package kr.kh.test.utils;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorAdvise {
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e, Model model) {
		
		//model은 화면에 넘겨줄 정보가 있는 경우에 사용
		return "/error/500";
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNoHandlerFoundException(NoHandlerFoundException e, Model model) {
		
		//model은 화면에 넘겨줄 정보가 있는 경우에 사용
		return "/error/404";
	}
}
