package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component("log")
public class LogAdvice {
//	public void beforeLog() {
//		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
//	}

	public void afterLog() {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
	}

	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");

		try {
			pjp.proceed(); // ���� ������ �޼ҵ� ȣ��(get Info()ȣ��)
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
	}
}
