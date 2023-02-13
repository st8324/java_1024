package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberDAO memberDao;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		if(memberDao.insertMember(member) != 0)
			return true;
		return false;
	}
}
