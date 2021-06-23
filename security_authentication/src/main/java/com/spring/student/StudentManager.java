package com.spring.student;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class StudentManager implements AuthenticationProvider, InitializingBean {

	private HashMap<String, Student> studentDB = new HashMap<String, Student>();
	
	
	//db로 대체
	@Override
	public void afterPropertiesSet() throws Exception {
		Set.of(
				new Student("hong","홍길동",Set.of(new SimpleGrantedAuthority("ROLE_STUDENT"))),
				new Student("kang","강아지",Set.of(new SimpleGrantedAuthority("ROLE_STUDENT"))),
				new Student("kim","김지호",Set.of(new SimpleGrantedAuthority("ROLE_STUDENT")))
				).forEach(student -> studentDB.put(student.getId(), student));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		if(studentDB.containsKey(token.getName())) {
			Student student = studentDB.get(token.getName());
			
			StudentAuthenticationToken studentAuthenticationToken = new StudentAuthenticationToken();
			studentAuthenticationToken.setPrincipal(student);
			studentAuthenticationToken.setDetails(student.getUsername());
			studentAuthenticationToken.setAuthenticated(true);
			
			return studentAuthenticationToken;
			
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication == UsernamePasswordAuthenticationToken.class;
	}

}
