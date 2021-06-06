package com.spring.annotation;

public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("=======> SonySpeaker °´Ã¼ »ý¼º");
	}
	@Override
	public void VolumeUp() {
		System.out.println("=======>SonySpeaker volume Up");
	}@Override
	public void VolumeDown() {
		System.out.println("=======>SonySpeaker volume Down");
	}
}
