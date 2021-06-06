package com.spring.scan;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {

	//생성된 객체 주입(둘 중에 생성되어있으면 아무거나 넣어줘)->활성화시키기위해
	//<context:annotation-config>
	//@Autowired
	@Inject
	@Qualifier("speaker2") //주입은 안해줌(이름으로 주입 대상을 결정) => 실제 주입을 해주는것은 아님
	private Speaker speaker; //SonySpeaker or SamsungSpeaker( 
	
	public SamsungTV() { //default 생성자
		System.out.println("SamsungTV - 객체 생성(1)");
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
		speaker.VolumeUp();
	}

	@Override
	public void soundDown() {
		speaker.VolumeDown();
	}

}
