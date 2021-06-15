package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.domain.ChangeVO;
import com.spring.domain.MemberVO;
import com.spring.domain.leaveVO;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;


@RestController
@Log4j2
public class MemberRestController {
	
	@Autowired
	private MemberService service;
	//회원 정보 수정
	
	@PutMapping("/changepwd2")
	public ResponseEntity<String> changePwd(@RequestBody ChangeVO vo, HttpSession session) {
		log.info("rest 수정" +vo);
		
		if (vo.newPasswordEqualConfirmPassword()) {
			if (service.modify(vo)) { // 비밀번호가 수정 성공
				session.invalidate();
				return new ResponseEntity<String>("success", HttpStatus.OK);
			} else { // 현재 비밀번호 오류
				//rttr.addFlashAttribute("error","현재 비밀번호를 확인해 주세요");
				return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
			}
		} else { // 변경 비밀번호와 확정 비밀번호가 다른 경우
			//rttr.addFlashAttribute("error","변경 비밀번호가 다릅니다.");
			return new ResponseEntity<String>("not-equal", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@DeleteMapping("/leave2")
	public ResponseEntity<String> leavePost(@RequestBody leaveVO vo, HttpSession session)  {
		log.info("회원 탈퇴 요청" +vo);
		
		if (service.leave(vo.getUserid(), vo.getCurrent_password())) {
			session.invalidate();
			return new ResponseEntity<String>("success",HttpStatus.OK);
		} else { 
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
}
