package com.spring.mapper;

import com.spring.security.SpUserAuthority;
import com.spring.security.spUser;

public interface MemberMapper {
	
	public int register(spUser user);
	public int registerAuth(SpUserAuthority auth);
	public spUser select(String userid);
}
