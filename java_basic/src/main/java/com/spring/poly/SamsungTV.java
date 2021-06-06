package com.spring.poly;

public class SamsungTV implements TV {
	
	
	//멤버변수,property,인스턴스 변수 => 속성
	//멤버변수는 초기화를 해줌
	
	//private int num;
	private Speaker speaker; //null
	
	public SamsungTV() {}
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void turnOn() {
		System.out.println("Samsung TV - 파워 On");
	}

	@Override
	public void turnOff() {
		System.out.println("Samsung TV - 파워 Off");
	}

	@Override
	public void soundUp() {
		//System.out.println("Samsung TV - volumeUp");
		speaker.VolumeUp();
		//System.out.println(speaker);
	}

	@Override
	public void soundDown() {
		//System.out.println("Samsung TV - volumeDown");
		speaker.VolumeDown();
	}

}
