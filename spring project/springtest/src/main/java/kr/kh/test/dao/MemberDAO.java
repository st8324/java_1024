package kr.kh.test.dao;

import org.apache.ibatis.annotations.Param;

public interface MemberDAO {

	String selectMemberName(@Param("num")Integer num);

}
