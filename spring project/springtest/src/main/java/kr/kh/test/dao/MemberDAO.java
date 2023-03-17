package kr.kh.test.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.test.vo.MemberOKVO;
import kr.kh.test.vo.MemberVO;

public interface MemberDAO {

	String selectMemberName(@Param("num")Integer num);

	int insertMember(@Param("member")MemberVO member);

	MemberVO selectMemberById(@Param("me_id")String me_id);

	void insertMemberOK(@Param("mok")MemberOKVO mok);

	int deleteMemberOK(@Param("mok")MemberOKVO mok);

	int updateMembetAuthority(@Param("me_id")String me_id, @Param("me_authority")int me_authority);

	void updateSession(@Param("member")MemberVO user);

	MemberVO selectMemberBySession(@Param("me_session_id")String me_session_id);

}
