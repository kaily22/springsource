package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member/*")
public class MemberController {

	
	@RequestMapping("/register")
	public void register() {
		log.info("register ��û");  
  }	
	@RequestMapping("/modify")
	public String update() {
		log.info("update ��û");
		
		return "member/member_modify";
	}
	
	@GetMapping("/login") //http://localhost:8081/member/login
	public void loginGet() {
		log.info("login ��û"); //member/login jspã�µ� �����
	}
	
	@PostMapping("/login") //http://localhost:8081/member/login
	public void loginPost() {
		log.info("login form ������ ��������"); //member/login jspã�µ� �����
	}
	
}
