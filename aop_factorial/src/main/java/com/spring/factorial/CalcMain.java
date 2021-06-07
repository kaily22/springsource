package com.spring.factorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcMain {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Calculator cal = (Calculator) ctx.getBean("fact");

		System.out.println("for 10! = " + cal.factorial(10));
		System.out.println();

		cal = (Calculator) ctx.getBean("rec");
		System.out.println("recursion 10! = " + cal.factorial(10));
	}

}
