package kr.kh.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/")
	public ModelAndView home(ModelAndView mv) {
		mv.setViewName("/main/home");
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
}
