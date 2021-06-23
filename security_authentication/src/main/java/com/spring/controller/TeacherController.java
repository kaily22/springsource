package com.spring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2

public class TeacherController {
	
	@GetMapping("/teacher")
	@PreAuthorize("hasAnyAuthority('ROLE_TEACHER')")
	public String teacherGet() {
		log.info("teacherPage form ฟไรป");
		return "security/TeacherPage";
		
	}
}
