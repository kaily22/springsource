package com.spring.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	//Implicit super constructor User() is undefined for default constructor(����Ʈ ������ x)
	
	private MemberVO memberVO;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	} 
	
	//list->stream���� -> �����ϱ� ���ؼ� map ���
	public CustomUser(MemberVO memberVO) {
		super(memberVO.getUserid(), memberVO.getUserpw(), 
				memberVO.getAuthList()
				.stream()
				//collectors.toList() ����Ʈ�� �����
				.map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.memberVO = memberVO;
	}
}
