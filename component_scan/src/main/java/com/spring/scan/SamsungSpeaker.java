package com.spring.scan;

import org.springframework.stereotype.Component;

@Component("speaker2")
public class SamsungSpeaker implements Speaker{
	
	public SamsungSpeaker() {
		System.out.println("=======> SamsungSpeaker °´Ã¼ »ý¼º");
	}
	public void soundUp() {
		System.out.println("===SamsungSpeaker soundUp");
	}
	public void soundDown() {
		System.out.println("===SamsungSpeaker soundDown");
	}
	public void VolumeUp() {
		System.out.println("===SamsungSpeaker soundUp");
	}
	public void VolumeDown() {
		System.out.println("===SamsungSpeaker soundDown");
	}
	
}
