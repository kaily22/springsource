package com.spring.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Criteria {
	
	private int pageNum; //����ڰ� Ŭ���ϴ� ������ ��ȣ
	private int amount; //�ϳ��� �������� ������ �Խù� ����
	
	
	//�˻� �߰�
	private String type;  //�˻�����
	private String keyword; //�˻���
	
	public Criteria() {
		this(1,10);
		
	}
	public Criteria(int pageNum, int amount) {
		super();
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public String[] getTypeArr() {
		//type => TCW => {"T","C","W"}, TC=>{"T","C"}, T=>{"T"}
		return type==null?new String[]{}:type.split("");
	}
}
