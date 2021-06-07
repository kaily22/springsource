package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component("log")
public class LogAdvice {
	
//	@Before(value="execution(* com.spring.domain.Product.getInfo())")
//	public void beforeLog() {
//		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
//	}
	
//	@After(value="execution(* com.spring.domain.Product.getInfo())")
//	public void afterLog() {
//		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
//	}
	
	
	@Around(value="execution(* com.spring.domain.Product.getInfo())")
	public void aroundLog(ProceedingJoinPoint pjp) {
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");
	
		try {
			pjp.proceed(); //���� ������ �޼ҵ� ȣ��
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("[����α�] ����Ͻ� ���� ���� �� ȣ��");	
	}
}
