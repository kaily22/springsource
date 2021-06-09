package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.ChangeVO;
import com.spring.domain.LoginVO;
import com.spring.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	MemberService service;

	// login.jsp 보여주기
	@GetMapping("/login")
	public void login() {
		log.info("login요청");

	}

	// 로그인 정보 가져오기 => post
	@PostMapping("/login")
	public String loginPost(String userid, @RequestParam("current_password") String password, HttpSession session,
			RedirectAttributes rttr) {
		log.info("로그인 정보 가져오기 : " + userid + " " + password);

		// 서비스 작업
		LoginVO login = service.login(userid, password);

		if (login == null) {
			rttr.addFlashAttribute("error", "아이디나 비밀번호를 확인해주세요");
			return "redirect:login";
		} else {
			session.setAttribute("login", login);
			return "redirect:/";
		}
	}

	// member/change-pwd => modify.jsp
	@GetMapping("/change-pwd")
	public String modify() {
		log.info("비밀번호 수정하기");
		return "/member/modify";
	}

	@PostMapping("/change-pwd")
	public String modifyPost(ChangeVO change, HttpSession session,RedirectAttributes rttr) {
		log.info("비밀번호 수정하기" + change);

		if (change.newPasswordEqualConfirmPassword()) {
			if (service.modify(change)) { // 비밀번호가 수정 성공
				session.invalidate();
				return "redirect:/member/login";
			} else { // 현재 비밀번호 오류
				rttr.addFlashAttribute("error","현재 비밀번호를 확인해 주세요");
				return "redirect:/member/change-pwd";
			}
		} else { // 변경 비밀번호와 확정 비밀번호가 다른 경우
			rttr.addFlashAttribute("error","변경 비밀번호가 다릅니다.");
			return "redirect:/member/change-pwd";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		log.info("로그아웃");
		// session.invalidate();
		session.removeAttribute("login");

		return "redirect:/";
	}

	// leave
	@GetMapping("/leave")
	public void leave() {
		log.info("회원 탈퇴하기 요청");
	}

	@PostMapping("/leave")
	public String leavePost(String userid, @RequestParam("current_password") String password, HttpSession session) {
		log.info("회원 탈퇴 정보 : " + userid + " " + password);

		if (service.leave(userid, password)) {
			session.invalidate();
			return "redirect:/";
		} else {
			// rttr.addFlashAttribute("check" ,"비밀번호를 확인해주세요");
			return "/member/leave";

		}

	}

}