package com.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser2 {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config3.xml");
		
		TV tv = (TV)ctx.getBean("samsung");
		
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}
