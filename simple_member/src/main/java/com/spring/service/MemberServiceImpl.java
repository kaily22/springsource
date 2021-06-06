package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.domain.MemberVO;
import com.spring.mapper.MemberMapper;

@Service("service")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper mapper;
	
	@Override
	public boolean insert(MemberVO vo) {
		// TODO Auto-generated method stub
		return mapper.insert(vo) >0 ? true: false;
	}

	@Override
	public boolean update(String userid, String password, String changePassword) {
		return mapper.update(userid, password, changePassword)>0? true:false;
	}

	@Override
	public boolean delete(String userid, String password) {
		return mapper.delete(userid, password) > 0 ? true:false;
	}

	@Override
	public MemberVO login(String userid, String password) {
		return mapper.login(userid, password);
	}

}
