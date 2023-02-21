package kr.kh.test.service;

import java.util.regex.Pattern;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.test.dao.MemberDAO;
import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	String contextPath = "/test";

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
		boolean isSignup = memberDao.insertMember(member) != 0;
		//회원가입에 실패하면 이메일 인증 메일을 보낼 필요가 없음
		if(!isSignup)
			return false;
		//이메일 인증 메일 보내기
		//랜덤으로 6자리 문자열 생성
		String randomStr = createRandom(6);
		//MemberOKVO 객체 생성
		MemberOKVO mok = new MemberOKVO(member.getMe_id(), randomStr);
		//MemberOKVO 객체를 DB에 저장
		memberDao.insertMemberOK(mok);
		//이메일 전송
		String title = "이메일 인증을 해주세요.";
		String href = getHref(mok);
		String content = "<a href='"+href+"'>이메일 인증 링크</a>을 클릭해서 회원 가입을 완료해주세요.";
		sendEmail(title, content, member.getMe_email());
		return true;
	}
	private void sendEmail(String title, String content, String email) {
		String setfrom = "stajun@gmail.com";         
	    
		try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(email);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(content, true);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	    }
	}

	private String getHref(MemberOKVO mok) {
		String href = "http://localhost:8080"+contextPath+"/email/authentication?mo_me_id="
			+mok.getMo_me_id() + "&mo_num=" + mok.getMo_num();
		return href;
	}
	
	private String createRandom(int size) {
		String pattern = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int min = 0, max = pattern.length()-1;
		String randomStr = "";
		while(randomStr.length() < size) {
			int r = (int)(Math.random()*(max-min+1)+min);
			randomStr += pattern.charAt(r);
		}
		return randomStr;
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
