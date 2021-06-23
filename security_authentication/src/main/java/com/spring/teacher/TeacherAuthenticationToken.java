package com.spring.teacher;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TeacherAuthenticationToken implements Authentication {

	private Teacher principal;
	private String credentials;
	private String details;
	private boolean authenticated;
	
	
	@Override
	public String getName() {
		return principal == null ? "" : principal.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return principal == null ? new HashSet<GrantedAuthority>():principal.getRole();
	}
	
}
