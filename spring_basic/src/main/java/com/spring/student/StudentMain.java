package com.spring.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	public static void main(String[] args) {
		
//		StudentInfo info = new StudentInfo(new Student("ȫ�浿","15","1","4"));
//		info.getIfno();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config4.xml");
		StudentInfo info = (StudentInfo) ctx.getBean("info");
		info.getIfno();
		
		
		
	}

}
