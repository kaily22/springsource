package com.spring.annotation;

public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("=======> SonySpeaker ��ü ����");
	}
	@Override
	public void VolumeUp() {
		System.out.println("=======>SonySpeaker volume Up");
	}@Override
	public void VolumeDown() {
		System.out.println("=======>SonySpeaker volume Down");
	}
}
