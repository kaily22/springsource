package com.spring.security;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class spUser {
	private String userid;
	private String email;
	private boolean enabled;
	private String password;
	
	private List<SpUserAuthority> authorities;  
}
