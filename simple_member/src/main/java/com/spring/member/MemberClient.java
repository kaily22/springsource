package com.spring.member;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;


public class MemberClient {

	public static void main(String[] args) {

			
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		MemberService service = (MemberService) ctx.getBean("service");
		
//		//회원가입
//		MemberVO vo = new MemberVO();
//		vo.setUserid("hello123");
//		vo.setPassword("hello12345!");
//		vo.setName("이승미");
//		vo.setGender("여");
//		vo.setEmail("hello12345@naver.com");
//		System.out.println(service.insert(vo)? "가입 성공":"가입 실패");
//		
//		//비밀번호 수정
//		MemberVO update = new MemberVO();
//		update.setPassword("hello111!");
//		System.out.println(service.update("ky12345", "ky12341234!" , "ky12341234!")? "수정 성공":" 수정 실패");
//		
//		//회원 삭제
//		System.out.println(service.delete("kailyyy0202", "hy123456!")? "삭제 성공":"삭제 실패");
		
		//로그인
		System.out.println(service.login("ky12345", "ky12341234!"));
	}
}
