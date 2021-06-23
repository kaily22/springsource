package com.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2

public class StudentController {
	
	@GetMapping("/student")
	@PreAuthorize("hasAnyAuthority('ROLE_STUDENT')")
	public String teacherGet() {
		log.info("student form ฟไรป");
		return "security/StudentPage";
		
	}
}
