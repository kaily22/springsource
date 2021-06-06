package com.spring.scan;

import org.springframework.stereotype.Component;

@Component("lg")  //lg 라는 id로 LgTV객체 생성
public class LgTV implements TV {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub

	}

	@Override
	public void soundUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void soundDown() {
		// TODO Auto-generated method stub

	}

}
