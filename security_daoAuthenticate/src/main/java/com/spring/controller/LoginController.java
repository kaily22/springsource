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
//		log.info("login ������ ��û");
//	}
//	
//	
//	@PostMapping("/login")
//	public void loginPost(String userid ,String current_password) {
//		log.info("�α��� ��û");
//		
//		//encode() : ��й�ȣ�� �ܹ��� ��ȣȭ
//		log.info("password : "+encoder.encode(current_password));
//	}
}
