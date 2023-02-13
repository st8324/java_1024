package kr.kh.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.MemberOKVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	int insertMember(@Param("m")MemberVO member);

	void insertMemberOK(@Param("mok")MemberOKVO mok);

}
