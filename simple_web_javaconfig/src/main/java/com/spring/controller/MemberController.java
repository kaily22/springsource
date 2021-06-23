package com.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.domain.LoginVO;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member/*")
public class MemberController {

	
	@RequestMapping("/register")
	public void register() {
		log.info("register 요청");  
  }	
	@RequestMapping("/modify")
	public String update() {
		log.info("update 요청");
		
		return "member/member_modify";
	}
	
	@GetMapping("/login") //http://localhost:8081/member/login
	public void loginGet() {
		log.info("login 요청"); //member/login jsp찾는데 도움됨
	}
	
	// 사용자의 입력값 가져오기 -1)HttpRequest사용
//	@PostMapping("/login") //http://localhost:8081/member/login
//	public void loginPost(HttpServletRequest req) {
//		log.info("login form 데이터 가져오기"); //member/login jsp찾는데 도움됨
//		log.info("userid :" +req.getParameter("userid"));
//		log.info("password :" +req.getParameter("password"));
//		
//	}
	
	//사용자 입력값 가져오기 -2) 변수명 사용(폼 필드 이름과 일치)
//	@PostMapping("/login") //http://localhost:8081/member/login
//	public void loginPost(@RequestParam("userid") String userid, String password ) { //login.jsp name에 userid, password 넣어줬기 때문
//		log.info("login form 데이터 가져오기"); //member/login jsp찾는데 도움됨
//		log.info("userid :" +userid);
//		log.info("password :" +password);
//		
//	}
	
	//사용자 입력값 가져오기 -3) Vo 사용
	@PostMapping("/login") //http://localhost:8081/member/login
	public String loginPost(@ModelAttribute("vo") LoginVO vo, Model model ) { 
		//loginVO vo => 이름은 loginVO로 설정됨 => 이름을 지정하고 싶다면? => 지정했으니 안나옴
		log.info("login form 데이터 가져오기"); //member/login jsp찾는데 도움됨
		log.info("userid :" +vo.getUserid());
		log.info("password :" +vo.getPassword());
		
		//page에 1번이라는 값을 담는다.
		model.addAttribute("page",1);
		
		return "result"; //result 페이지 지시 -> forward 방식으로 움직임 /WEB-INF/views/result.jsp
	}	
}
