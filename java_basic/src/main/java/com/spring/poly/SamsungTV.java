package com.spring.poly;

public class SamsungTV implements TV {
	
	
	//�������,property,�ν��Ͻ� ���� => �Ӽ�
	//��������� �ʱ�ȭ�� ����
	
	//private int num;
	private Speaker speaker; //null
	
	public SamsungTV() {}
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - ��ü ����");
	}
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	@Override
	public void turnOn() {
		System.out.println("Samsung TV - �Ŀ� On");
	}

	@Override
	public void turnOff() {
		System.out.println("Samsung TV - �Ŀ� Off");
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
