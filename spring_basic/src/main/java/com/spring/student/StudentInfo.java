package com.spring.student;

public class StudentInfo {
	private Student student;
	
	public StudentInfo(Student student) {
		this.student = student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void getIfno() {
		System.out.println("�̸� : "+student.getName());
		System.out.println("���� : "+student.getAge());
		System.out.println("�г� : "+student.getGradeName());
		System.out.println("�� : "+student.getClassNum());
		
	}
}
