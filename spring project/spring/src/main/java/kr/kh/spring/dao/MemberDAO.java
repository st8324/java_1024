package kr.kh.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.A;
import kr.kh.spring.vo.MemberOKVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	int insertMember(@Param("m")MemberVO member);

	void insertMemberOK(@Param("mok")MemberOKVO mok);

	MemberOKVO selectMemberOK(@Param("mok")MemberOKVO mok);

	void deleteMemberOK(@Param("mok")MemberOKVO mok);

	void updateAuthority(@Param("me_id")String me_id, @Param("me_authority")int me_authority);

	MemberVO selectMemberById(@Param("me_id")String me_id);

	void updateSession(@Param("member")MemberVO user);

	MemberVO selectMemberBySession(@Param("me_session_id")String me_session_id);

	ArrayList<A> selectAList();

}
