package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class RegisterController {
	
	@Autowired
	private MemberService service;

	@GetMapping("/step1")
	public void step1Get() {
		log.info("step1 페이지 요청");
	}
	
//step1에서 약관동의를 한 후 넘어오는 처리
	@PostMapping("/step2")
	public String step2Post(boolean agree, RedirectAttributes rttr) {
		//log.info("step2페이지 요청");
		log.info("step2 페이지 요청" +agree);
			
		if(!agree) {
			//session에 
			rttr.addFlashAttribute("check", "false");
			//step1 다시 보여주기(forward) => jsp를 찾는게 아니라 컨트롤러를 찾는다.
			return "redirect:step1";
		}//true
		
		return "step2";
		
	}
	
	//step3
	@PostMapping("/step3")
	public String step3Post(@ModelAttribute("member") MemberVO vo) {
		log.info("회원가입 요청 "+vo);

//		log.info("userid :" +vo.getUserid());
//		log.info("password :" +vo.getPassword());
//		log.info("confirm_password :" +vo.getConfirm_password());
//		log.info("name :" +vo.getName());
//		log.info("gender :" +vo.getGender());
//		log.info("email :" +vo.getEmail());
		
		//서비스 작업
		if(service.insert(vo)) {
			return "redirect:/member/login";			
		}else{
			return "step2";
		} 
	}
	
	// /step2, /step3 직접 눌러서 접근하는 경우 -405에러
	@GetMapping(value= {"/step2","/step3"})
	public String handleStep() {
		return "redirect:step1";
	}
}
