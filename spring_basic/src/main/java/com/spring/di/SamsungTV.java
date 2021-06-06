package com.spring.di;

public class SamsungTV implements TV {
	
	//�����ϴ� ���� : hasa()
	//�������,property,�ν��Ͻ� ���� => �Ӽ�
	//��������� �ʱ�ȭ�� ����
	
	//private int num;
	private Speaker speaker; //null
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV - ��ü ����(1)");
	}
	
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
		System.out.println("SamsungTV - ��ü ����(2)");
	}
	
	public SamsungTV(Speaker speaker, int price) {

		super();
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV - ��ü ����(3)");
		System.out.println("SamsungTV ���� - "+this.price);
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
