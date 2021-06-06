package com.spring.member;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.MemberVO;
import com.spring.service.MemberService;


public class MemberClient {

	public static void main(String[] args) {

			
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		MemberService service = (MemberService) ctx.getBean("service");
		
//		//ȸ������
//		MemberVO vo = new MemberVO();
//		vo.setUserid("hello123");
//		vo.setPassword("hello12345!");
//		vo.setName("�̽¹�");
//		vo.setGender("��");
//		vo.setEmail("hello12345@naver.com");
//		System.out.println(service.insert(vo)? "���� ����":"���� ����");
//		
//		//��й�ȣ ����
//		MemberVO update = new MemberVO();
//		update.setPassword("hello111!");
//		System.out.println(service.update("ky12345", "ky12341234!" , "ky12341234!")? "���� ����":" ���� ����");
//		
//		//ȸ�� ����
//		System.out.println(service.delete("kailyyy0202", "hy123456!")? "���� ����":"���� ����");
		
		//�α���
		System.out.println(service.login("ky12345", "ky12341234!"));
	}
}
