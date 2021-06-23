package com.spring.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SecurityController {
	
	
	@GetMapping("/login")
	public String loginGet() {
		log.info("security-loginForm 요청");
		
		return "/security/loginForm";
	}
	
	@GetMapping("/user-page")
	public String userPage() {
		log.info("security-userpage 요청");
		
		return "/security/UserPage";
	}

	
	@GetMapping("/admin-page")
	public String adminPage() {
		log.info("security-adminpage 요청");
		
		return "/security/AdminPage";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		log.info("로그인 실패");
		
		model.addAttribute("loginError","아이디나 비밀번호가 올바르지 않습니다.");
		
		return "/security/loginForm";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		log.info("페이지 접근 제한");
		
		return "/security/AccessDenied";
		
	}
	
	
	@ResponseBody
	@GetMapping("/auth")
	public Authentication auth() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	
	/*
	 * {"authorities":[{"authority":"ROLE_USER"}], => 권한 정보
	 * "details":{"remoteAddress":"0:0:0:0:0:0:0:1","sessionId":"3C97D957786D713ED53760B4D2543522"}, =>HttpServer
	 * "authenticated":true,
	 * "principal":{"password":null,"username":"user1",
	 * "authorities":[{"authority":"ROLE_USER"}],
	 * "accountNonExpired":true,"accountNonLocked":true,
	 * "credentialsNonExpired":true,"enabled":true},"credentials":null,"name":"user1"}
	 * 
	 * 
	 * principal => 인증된 결과(인증된 대상)
	 * */
}
