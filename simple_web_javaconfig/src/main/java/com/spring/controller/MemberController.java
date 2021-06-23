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
	
	// ������� �Է°� �������� -1)HttpRequest���
//	@PostMapping("/login") //http://localhost:8081/member/login
//	public void loginPost(HttpServletRequest req) {
//		log.info("login form ������ ��������"); //member/login jspã�µ� �����
//		log.info("userid :" +req.getParameter("userid"));
//		log.info("password :" +req.getParameter("password"));
//		
//	}
	
	//����� �Է°� �������� -2) ������ ���(�� �ʵ� �̸��� ��ġ)
//	@PostMapping("/login") //http://localhost:8081/member/login
//	public void loginPost(@RequestParam("userid") String userid, String password ) { //login.jsp name�� userid, password �־���� ����
//		log.info("login form ������ ��������"); //member/login jspã�µ� �����
//		log.info("userid :" +userid);
//		log.info("password :" +password);
//		
//	}
	
	//����� �Է°� �������� -3) Vo ���
	@PostMapping("/login") //http://localhost:8081/member/login
	public String loginPost(@ModelAttribute("vo") LoginVO vo, Model model ) { 
		//loginVO vo => �̸��� loginVO�� ������ => �̸��� �����ϰ� �ʹٸ�? => ���������� �ȳ���
		log.info("login form ������ ��������"); //member/login jspã�µ� �����
		log.info("userid :" +vo.getUserid());
		log.info("password :" +vo.getPassword());
		
		//page�� 1���̶�� ���� ��´�.
		model.addAttribute("page",1);
		
		return "result"; //result ������ ���� -> forward ������� ������ /WEB-INF/views/result.jsp
	}	
}
