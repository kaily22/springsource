package com.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
//		SamsungTV samsung = new SamsungTV();
//		samsung.turnOn();
//		samsung.turnOff();
		
		
		//������ ���̰�, ���յ� ���߱�
		
		//�θ� = new �ڽ�(���(extends)�� �ִ� ���� or implements)
		//=>��� : ������
//	
//		TV tv = new SamsungTV(new SamsungSpeaker());
//		tv.turnOn(); // �ＺƼ�� �Ŀ� on
//		tv.soundUp(); 
//		tv.soundDown();
//		
//		//������ ����=> ���� ����ȯ ���// ClassCastException�� �� ����
//		//((SamsungTV)tv).setSpeaker(new SonySpeaker());
//		
//		tv.turnOff();
//		//�Ȱ��� �޼ҵ带 �ҷ��µ� ����� �ٸ� �� : ������
//		tv = new LgTV();
//		// LG Ƽ�� ���� on
//		tv.turnOn();	
		
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config2.xml");
		
		TV tv = (TV)ctx.getBean("samTv2");
		
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}
