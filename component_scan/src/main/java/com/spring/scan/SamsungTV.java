package com.spring.scan;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {

	//������ ��ü ����(�� �߿� �����Ǿ������� �ƹ��ų� �־���)->Ȱ��ȭ��Ű������
	//<context:annotation-config>
	//@Autowired
	@Inject
	@Qualifier("speaker2") //������ ������(�̸����� ���� ����� ����) => ���� ������ ���ִ°��� �ƴ�
	private Speaker speaker; //SonySpeaker or SamsungSpeaker( 
	
	public SamsungTV() { //default ������
		System.out.println("SamsungTV - ��ü ����(1)");
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
		speaker.VolumeUp();
	}

	@Override
	public void soundDown() {
		speaker.VolumeDown();
	}

}
