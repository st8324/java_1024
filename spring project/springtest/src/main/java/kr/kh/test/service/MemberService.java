package kr.kh.test.service;

import kr.kh.test.vo.MemberVO;

public interface MemberService {

	String selectMemberName(Integer num);

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

}
