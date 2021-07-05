package com.spring.transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.config.SampleConfig;
import com.spring.service.SampleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleMain {
	public static void main(String[] args) {
	
		log.info("main ½ÇÇà");
		
    ApplicationContext ctx = new AnnotationConfigApplicationContext(SampleConfig.class);
	SampleService service = (SampleService) ctx.getBean("sample");
	
	String data = "Starrry\r\n"
			     +"Starrry night\r\n"
			     + "Paint your paletter blue and grey\r\n"
			     + "Look out on a summer day";
	service.addData(data);
	
	}
}
