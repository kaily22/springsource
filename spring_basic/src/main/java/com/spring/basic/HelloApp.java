package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
//		MessageBean msg = new MessageBeanKo();
//		msg.sayHello("홍길동");
		
		System.out.println("스프링 컨테이너 구동");
		//1) 스프링 컨테이너 구동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		//2)스트링 컨테이너로부터 객체 lookup(컨테이너가 관리하는 빈 중에서 필요한 빈 찾기)
		MessageBean msg = (MessageBean)ctx.getBean("messageBean");
		//3)실행
		msg.sayHello("hong");
		
	}
}
