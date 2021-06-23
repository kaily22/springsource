package com.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j2;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j2
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		log.info("index 요청");
		
		return "index";
	}
	
	@GetMapping("/login")
	public String loginGet() {
		log.info("로그인 폼 요청");
		return "/security/loginForm";
	}
	
	@GetMapping("/login-error")
	public String loginError(Model model) {
		log.info("로그인 에러");
		
		model.addAttribute("loginError", "아이디나 비밀번호를 확인해 주세요");
		
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
