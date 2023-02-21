package kr.kh.test.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.MemberDAO;
import kr.kh.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public String selectMemberName(Integer num) {
		if(num == null)
			return null;
		return memberDao.selectMemberName(num);
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		String idRegex = "^[a-zA-Z][a-zA-Z0-9!@#$]{4,12}$";
		String pwRegex = "^[a-zA-Z0-9!@#$]{8,20}$";
		//회원 정보 유효성 검사
		if(member.getMe_id() == null || 
			!Pattern.matches(idRegex, member.getMe_id()))
			return false;
		if(member.getMe_pw() == null || 
			!Pattern.matches(pwRegex, member.getMe_pw()))
			return false;
		if(member.getMe_email() == null)
			return false;
		if(member.getMe_birthday() == null)
			return false;
		//비밀번호 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		//회원가입
		return memberDao.insertMember(member) != 0;
	}

	@Override
	public MemberVO login(MemberVO member) {
		//아이디, 비번 유효성 검사
		if(member == null)
			return null;
		String idRegex = "^[a-zA-Z][a-zA-Z0-9!@#$]{4,12}$";
		String pwRegex = "^[a-zA-Z0-9!@#$]{8,20}$";
		if(member.getMe_id() == null || 
				!Pattern.matches(idRegex, member.getMe_id()))
			return null;
		if(member.getMe_pw() == null || 
				!Pattern.matches(pwRegex, member.getMe_pw()))
			return null;
		//아이디가 일치하는 회원 정보를 가져옴
		MemberVO user = memberDao.selectMemberById(member.getMe_id());

		if(user == null)
			return null;
		//입력한 비번과 암호화된 비번이 같은지를 확인
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw()))
			return user;
		return null;
	}
}
