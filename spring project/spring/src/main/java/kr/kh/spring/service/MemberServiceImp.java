package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberOKVO;
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

	@Override
	public void emailAuthentication(String me_id) {
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
		MemberOKVO mok = new MemberOKVO(me_id, str);
		memberDao.insertMemberOK(mok);
	}
}
