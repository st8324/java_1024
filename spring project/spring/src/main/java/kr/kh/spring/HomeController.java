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
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping(value = "/ex1")
	public ModelAndView ex1(ModelAndView mv,String name, Integer age) {
		System.out.println("예제1 - 화면에서 전달한 이름 : " + name);
		System.out.println("예제1 - 화면에서 전달한 나이 : " + age);
		mv.setViewName("ex1");
		return mv;
	}
	@RequestMapping(value = "/ex2")
	public ModelAndView ex2(ModelAndView mv,String name, Integer age) {
		System.out.println("예제2 - 화면에서 전달한 이름 : " + name);
		System.out.println("예제2 - 화면에서 전달한 나이 : " + age);
		mv.setViewName("ex2");
		return mv;
	}
	@RequestMapping(value = "/ex3")
	public ModelAndView ex3(ModelAndView mv) {
		mv.setViewName("ex3");
		return mv;
	}
	@RequestMapping(value = "/ex3/{name}/{age}")
	public ModelAndView exNameAge3(ModelAndView mv,
			@PathVariable("name")String name,
			@PathVariable("age")int age) {
		System.out.println("예제3 - 화면에서 전달한 이름 : " + name);
		System.out.println("예제3 - 화면에서 전달한 나이 : " + age);
		mv.setViewName("ex3");
		return mv;
	}
}
