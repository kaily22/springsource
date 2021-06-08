package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.mapper.MemberMapper;



@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;

	@Override
	public boolean insert(MemberVO vo) {
		return mapper.insert(vo) > 0? true:false;
	}

	@Override
	public MemberVO dupId(String userid) {
		return null;
	}

}
