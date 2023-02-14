package kr.kh.spring.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberOKVO;
import kr.kh.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	@Autowired
	MemberDAO memberDao;
	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null)
			return false;
		String newPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(newPw);
		if(memberDao.insertMember(member) != 0)
			return true;
		return false;
	}

	@Override
	public void emailAuthentication(String me_id, String me_email) {
		String str = authenticationNumber();
		MemberOKVO mok = new MemberOKVO(me_id, str);
		memberDao.insertMemberOK(mok);
		
		String title = "[Spring]이메일 인증 메일입니다.";
		String content = 
			"다음 링크를 클릭해서 이메일 인증을 완료하세요.<br>" + 
			"<a href='http://localhost:8080/spring/email?mo_num="+str+"&mo_me_id="+me_id+"'>이메일 인증하기</a>";
		//이메일 전송
		sendEmail(title, content, me_email);
	}
	private String authenticationNumber() {
		//인증번호 생성 : 6자리, 영어, 숫자로 된 인증 번호
		String str = "";
		int max = 61, min = 0;
		//영어 소문자 : 26개, 영어 대문자 : 26개, 숫자 : 10개 총 : 62개
		while(str.length() != 6) {
			int r = (int)(Math.random()*(max-min + 1) + min);
			//숫자 0~9
			if(r <= 9) {
				str += r;
			}
			//영어 소문자 10~35. 10=>a, 11=>b,... 35=>z
			else if(r <= 35) {
				str += (char)('a'+(r-10));
			}
			else {
				str += (char)('A'+(r-36));
			}
		}
		return str;
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
	        //setText에 true를 추가하면, content에 있는 html코드를 html코드로 적용
	        messageHelper.setText(content, true);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	    }
	}

	@Override
	public boolean emailAuthenticationConfirm(MemberOKVO mok) {
		if(mok == null)
			return false;
		MemberOKVO dbMok = memberDao.selectMemberOK(mok);
		if(dbMok != null) {
			//member_ok 테이블에서 해당 데이터를 삭제하고
			memberDao.deleteMemberOK(mok);
			//member테이블에서 해당 회원의 권한을 1로 등급업
			memberDao.updateAuthority(mok.getMo_me_id(), 1);
			return true;
		}
		return false;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null 
			|| member.getMe_pw() == null)
			return null;
		MemberVO dbMember = memberDao.selectMemberById(member.getMe_id());
		if(dbMember == null)
			return null;
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw()))
			return dbMember;
		return null;
	}
}
