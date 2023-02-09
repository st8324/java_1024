package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberDAO memberDao;

	@Override
	public String getNameByNum(String num) {
		if(num == null)
			return null;
		return memberDao.selectMemberName(num);
	}
}
