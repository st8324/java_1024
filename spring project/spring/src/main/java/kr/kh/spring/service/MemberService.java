package kr.kh.spring.service;

import java.util.ArrayList;

import kr.kh.spring.vo.A;
import kr.kh.spring.vo.MemberOKVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	void emailAuthentication(String me_id, String me_email);

	boolean emailAuthenticationConfirm(MemberOKVO mok);

	MemberVO login(MemberVO member);

	boolean checkId(MemberVO user);

	void updateMemberBySession(MemberVO user);

	MemberVO getMemberBySession(String me_session_id);

	ArrayList<A> getAList();

}
