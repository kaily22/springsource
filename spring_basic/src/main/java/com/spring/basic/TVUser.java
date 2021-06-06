package com.spring.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	
	public static void main(String[] args) {
//		LgTV tv = new LgTV();
//		tv.turnOn();
//		tv.turnOff();
//		tv.soundUp();
//		tv.soundDown();
//		
//		SamsungTV samsung = new SamsungTV();
//		samsung.powerOn();
//		samsung.volumeUp();
//		samsung.volumeUp();
//		samsung.powerOff();		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		LgTV lg = (LgTV) ctx.getBean("lg");
		lg.turnOn();
		lg.soundUp();
		lg.soundUp();
		lg.turnOff();
		
		SamsungTV samsung = (SamsungTV) ctx.getBean("samsung");
		samsung.powerOn();
		samsung.volumeUp();
		samsung.volumeUp();
		samsung.powerOff();
		

		SamsungTV samsung2 = (SamsungTV) ctx.getBean("samsung");
		
		
		if(samsung == samsung2) {
			System.out.println(samsung==samsung2); //true => SingleTon
		}
	}
}
