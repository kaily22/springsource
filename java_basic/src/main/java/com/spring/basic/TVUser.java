package com.spring.basic;

public class TVUser {
	
	public static void main(String[] args) {
		LgTV tv = new LgTV();
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
		
		SamsungTV samsung = new SamsungTV();
		samsung.powerOn();
		samsung.volumeUp();
		samsung.volumeUp();
		samsung.powerOff();		
				
	}
}
