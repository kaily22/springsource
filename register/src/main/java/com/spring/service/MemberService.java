package com.spring.service;

import com.spring.domain.MemberVO;

public interface MemberService {
	public boolean insert(MemberVO vo);
	public MemberVO dupId(String userid);
}
