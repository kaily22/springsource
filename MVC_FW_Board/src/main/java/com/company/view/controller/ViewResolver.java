package com.company.view.controller;

public class ViewResolver {
	//�ʵ� ����
	public String prefix; //���λ�
	public String suffix; //���̻�
	
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	//����� ���� �޼ҵ�
	/*
	 * 
	 * (��) �������� �� => ./getBoardList.jsp
	 * 			 	./=> ���λ� setPrefix("./");
	 * 				.jsp => ���̻� setSuffix(".jsp");
	 * 
	 */
	public String getView(String viewName) {
		
		return prefix + viewName + suffix;
	}
}