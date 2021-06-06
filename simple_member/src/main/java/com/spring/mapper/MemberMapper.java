package com.spring.mapper;


import org.apache.ibatis.annotations.Param;

import com.spring.domain.MemberVO;


public interface MemberMapper {
	

	public int insert(MemberVO vo);
	public int update(@Param("userid") String userid, @Param("password")String password, @Param("changePassword") String changePassword);
	public int delete(@Param("userid") String userid, @Param("password")String password);
	public MemberVO login(@Param("userid") String userid, @Param("password")String password);

}
