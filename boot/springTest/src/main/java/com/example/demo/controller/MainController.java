package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.MemberService;

@Controller
public class MainController {
	@Autowired
	private MemberService memberService;
	
	



	@GetMapping("/")
	public String main() {
		System.out.println(memberService.getMember("qwe123"));
		return "contents/home";
	}
}
