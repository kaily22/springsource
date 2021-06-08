package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.domain.CalcVO;

import lombok.extern.log4j.Log4j2;

@RequestMapping("/calc/*")
@Controller
@Log4j2
public class AddController {

	// @RequestMapping(value = "/add", method=RequestMethod.GET)
	@GetMapping("/add")
	public void addForm() {
		log.info("add.jsp ��û");
	}

	@PostMapping("/add")
	// Ÿ�� ��ȯ �˾Ƽ� ����
	public void addPost(int num1, int num2) {
		log.info("add �� ��������");
		log.info("num1:" + num1);
		log.info("num2:" + num2);
	}

	// get���� ���� �� ����
	@GetMapping("/four")
	public void fourForm() {
		log.info("four.jsp ��û");
	}

//	@PostMapping("/four")
//	public void fourPost(int num1, String op, int num2) {
//		log.info("��Ģ ���� �� ��������");
//		log.info("num1 : " +num1);
//		log.info("op : " +op);
//		log.info("num2 : " +num2);
//	}

	@PostMapping("/four")
	public void fourPost(CalcVO calc, @ModelAttribute("page") int page) {
		log.info("��Ģ ���� �� ��������");
		log.info("num1 : " + calc.getNum1());
		log.info("op : " + calc.getOp());
		log.info("num2 : " + calc.getNum2());
		log.info("page: " +page);
		
		//page���� �����ϰ� �ʹٸ�?
		//model.addAttribute("page",page);
	}
}
