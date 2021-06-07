package com.spring.domain;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Component
public class Product {
	private String company;
	private String pname;
	private String price;
	
	public void getInfo() //throws Exception
	{
		//System.out.println("====getInfo() ����======");
		System.out.println("ȸ��� : " +company);
		System.out.println("��ǰ�� : " +pname);
		System.out.println("���� : " +price);
		
		//throw new Exception("���� ����");
	}
}
