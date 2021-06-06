package com.spring.basic;

public class MessageBeanKo implements MessageBean {
	@Override
	public void sayHello(String name) {
		System.out.println("¾È³ç!!" +name);
	}
}
