package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mapper.MemberMapper;
import com.spring.security.SpUserAuthority;
import com.spring.security.spUser;

@Service
public class MemberServiceImpl implements MemberService {

	
	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//둘중에 하나 실패=>트랜잭션 걸어주기
	@Transactional
	@Override
	public boolean register(spUser user) {
		//회원 정보 등록 전 비밀번호 암호화
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		//회원 정보 등록
		boolean result = mapper.register(user)==1;
		
		//회원권한 등록
		SpUserAuthority auth = new SpUserAuthority();
		auth.setUserid(user.getUserid());
		auth.setAuthority("ROLE_USER");
			
		mapper.registerAuth(auth);
		
		return result;
	}

}
