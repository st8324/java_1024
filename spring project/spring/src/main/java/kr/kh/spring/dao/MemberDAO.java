package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.MemberOKVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	int insertMember(@Param("m")MemberVO member);

	void insertMemberOK(@Param("mok")MemberOKVO mok);

	MemberOKVO selectMemberOK(@Param("mok")MemberOKVO mok);

	void deleteMemberOK(@Param("mok")MemberOKVO mok);

	void updateAuthority(@Param("me_id")String me_id, @Param("me_authority")int me_authority);

	MemberVO selectMemberById(@Param("me_id")String me_id);

}
