package com.spring.teacher;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class TeacherManager implements AuthenticationProvider, InitializingBean {

	private HashMap<String, Teacher> teacherDB = new HashMap<String, Teacher>();
	
	
	//db로 대체
	@Override
	public void afterPropertiesSet() throws Exception {
		Set.of(
				new Teacher("teacher1","최정환",Set.of(new SimpleGrantedAuthority("ROLE_TEACHER"))),
				new Teacher("teacher2","박서준",Set.of(new SimpleGrantedAuthority("ROLE_TEACHER"))),
				new Teacher("teacher3","송지호",Set.of(new SimpleGrantedAuthority("ROLE_TEACHER")))
				).forEach(teacher -> teacherDB.put(teacher.getId(), teacher));
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		
		if(teacherDB.containsKey(token.getName())) {
			Teacher student = teacherDB.get(token.getName());
			
			TeacherAuthenticationToken studentAuthenticationToken = new TeacherAuthenticationToken();
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
