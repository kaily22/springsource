package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
//		SamsungTV samsung = new SamsungTV();
//		samsung.turnOn();
//		samsung.turnOff();
		
		
		//응집도 높이고, 결합도 낮추기
		
		//부모 = new 자식(상속(extends)에 있는 개념 or implements)
		//=>기능 : 다형성
//	
//		TV tv = new SamsungTV(new SamsungSpeaker());
//		tv.turnOn(); // 삼성티비 파워 on
//		tv.soundUp(); 
//		tv.soundDown();
//		
//		//다형성 구현=> 강제 형변환 사용// ClassCastException날 수 있음
//		//((SamsungTV)tv).setSpeaker(new SonySpeaker());
//		
//		tv.turnOff();
//		//똑같은 메소드를 불렀는데 결과가 다른 것 : 다형성
//		tv = new LgTV();
//		// LG 티비 전원 on
//		tv.turnOn();	
		
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		TV tv = (TV)ctx.getBean("samTv2");
		
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}
