package com.spring.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Component
@NoArgsConstructor
public class Product {
	private String company;
	private String pname;
	private String price;
	
	public void getInfo() //throws Exception
	{
		//횡단 관심사
//		System.out.println("====getInfo() 수행======");
		System.out.println("회사명 : " +company);
		System.out.println("제품명 : " +pname);
		System.out.println("가격 : " +price);
		
		//throw new Exception("강제 예외");
	}
}
