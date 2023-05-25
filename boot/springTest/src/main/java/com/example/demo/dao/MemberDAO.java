package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.vo.MemberVO;
@Repository
@Mapper
public interface MemberDAO {

	MemberVO selectMember(String id);

}
