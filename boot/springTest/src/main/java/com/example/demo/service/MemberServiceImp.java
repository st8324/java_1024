package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{
	@Autowired
	private MemberDAO memberDao;
	
	
	public MemberVO getMember(String string) {
		return memberDao.selectMember(string);
	}
}
