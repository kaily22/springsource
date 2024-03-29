package com.spring.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	//Implicit super constructor User() is undefined for default constructor(디폴트 생성자 x)
	
	private spUser spUser;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	} 
	
	//list->stream형태 -> 수집하기 위해서 map 사용
	public CustomUser(spUser spUser) {
		super(spUser.getUserid(), spUser.getPassword(), 
				spUser.getAuthorities()
				.stream()
				//collectors.toList() 리스트로 담겨줌
				.map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList()));
		this.spUser = spUser;
	}
}
