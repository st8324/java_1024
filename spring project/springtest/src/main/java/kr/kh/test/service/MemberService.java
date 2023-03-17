package kr.kh.test.service;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberService {

	String selectMemberName(Integer num);

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	boolean emailAuthentication(MemberOKVO mok);

	boolean checkId(MemberVO member);

	void updateSession(MemberVO user);

	MemberVO getMemberBySession(String me_session_id);

}
