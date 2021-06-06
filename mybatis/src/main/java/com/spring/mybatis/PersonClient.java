package com.spring.mybatis;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.PersonVO;
import com.spring.service.PersonService;

public class PersonClient {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		PersonService service = (PersonService) ctx.getBean("person");
		
//		service.insertPerson("kim", "±èÁöÈ«");
		
		List<PersonVO> list = service.getList();
		for(PersonVO vo : list) {
			System.out.println(vo);
			
		}
	}

}
