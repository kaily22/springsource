package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.security.spUser;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SecurityController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/register")
	public String registerGet() {
		log.info("security-registerForm ��û");
		
		return "/security/registerForm";
	}
	
	@PostMapping("/register")
	public String registerPost(spUser user) {
		log.info("registerForm ��û : " +user);
		
		service.register(user);
		
		return "redirect:/";
	}

	
	@GetMapping("/login")
	public String loginGet() {
		log.info("security-loginForm ��û");
		
		return "/security/loginForm";
	}
	
	@PreAuthorize("hasAnyAutority('ROLE_USER')")
	@GetMapping("/user-page")
	public String userPage() {
		log.info("security-userpage ��û");
		
		return "/security/UserPage";
	}

	@PreAuthorize("hasAnyAutority('ROLE_ADMIN')")
	@GetMapping("/admin-page")
	public String adminPage() {
		log.info("security-adminpage ��û");
		
		return "/security/AdminPage";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		log.info("�α��� ����");
		
		model.addAttribute("loginError","���̵� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
		
		return "/security/loginForm";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		log.info("������ ���� ����");
		
		return "/security/AccessDenied";
		
	}
	
	@ResponseBody
	@GetMapping("/auth")
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	
	/*
	 * {"authorities":[{"authority":"ROLE_USER"}], => ���� ����
	 * "details":{"remoteAddress":"0:0:0:0:0:0:0:1","sessionId":"3C97D957786D713ED53760B4D2543522"}, =>HttpServer
	 * "authenticated":true,
	 * "principal":{"password":null,"username":"user1",
	 * "authorities":[{"authority":"ROLE_USER"}],
	 * "accountNonExpired":true,"accountNonLocked":true,
	 * "credentialsNonExpired":true,"enabled":true},"credentials":null,"name":"user1"}
	 * 
	 * 
	 * principal => ������ ���(������ ���)
	 * */
}
