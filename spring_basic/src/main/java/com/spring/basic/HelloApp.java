package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
//		MessageBean msg = new MessageBeanKo();
//		msg.sayHello("ȫ�浿");
		
		System.out.println("������ �����̳� ����");
		//1) ������ �����̳� ����
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		//2)��Ʈ�� �����̳ʷκ��� ��ü lookup(�����̳ʰ� �����ϴ� �� �߿��� �ʿ��� �� ã��)
		MessageBean msg = (MessageBean)ctx.getBean("messageBean");
		//3)����
		msg.sayHello("hong");
		
	}
}
