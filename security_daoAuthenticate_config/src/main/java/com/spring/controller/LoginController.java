package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class LoginController {
	
//	@Autowired
//	private PasswordEncoder encoder;
//	
//	@GetMapping("/login")
//	public void loginGet() {
//		log.info("login 페이지 요청");
//	}
//	
//	
//	@PostMapping("/login")
//	public void loginPost(String userid ,String current_password) {
//		log.info("로그인 요청");
//		
//		//encode() : 비밀번호를 단방향 암호화
//		log.info("password : "+encoder.encode(current_password));
//	}
}
