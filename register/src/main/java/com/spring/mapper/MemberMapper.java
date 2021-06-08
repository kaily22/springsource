package com.spring.mapper;

import com.spring.domain.MemberVO;

public interface MemberMapper {
	
	public int insert(MemberVO vo);
	public MemberVO dupId(String userid);
	
}
