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
		log.info("step1 ������ ��û");
	}
	
//step1���� ������Ǹ� �� �� �Ѿ���� ó��
	@PostMapping("/step2")
	public String step2Post(boolean agree, RedirectAttributes rttr) {
		//log.info("step2������ ��û");
		log.info("step2 ������ ��û" +agree);
			
		if(!agree) {
			//session�� 
			rttr.addFlashAttribute("check", "false");
			//step1 �ٽ� �����ֱ�(forward) => jsp�� ã�°� �ƴ϶� ��Ʈ�ѷ��� ã�´�.
			return "redirect:step1";
		}//true
		
		return "step2";
		
	}
	
	//step3
	@PostMapping("/step3")
	public String step3Post(@ModelAttribute("member") MemberVO vo) {
		log.info("ȸ������ ��û "+vo);

//		log.info("userid :" +vo.getUserid());
//		log.info("password :" +vo.getPassword());
//		log.info("confirm_password :" +vo.getConfirm_password());
//		log.info("name :" +vo.getName());
//		log.info("gender :" +vo.getGender());
//		log.info("email :" +vo.getEmail());
		
		//���� �۾�
		if(service.insert(vo)) {
			return "redirect:/member/login";			
		}else{
			return "step2";
		} 
	}
	
	// /step2, /step3 ���� ������ �����ϴ� ��� -405����
	@GetMapping(value= {"/step2","/step3"})
	public String handleStep() {
		return "redirect:step1";
	}
}
