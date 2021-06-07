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
		//Ⱦ�� ���ɻ�
//		System.out.println("====getInfo() ����======");
		System.out.println("ȸ��� : " +company);
		System.out.println("��ǰ�� : " +pname);
		System.out.println("���� : " +price);
		
		//throw new Exception("���� ����");
	}
}
