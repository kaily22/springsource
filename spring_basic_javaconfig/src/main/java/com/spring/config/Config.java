package com.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.basic.LgTV;
import com.spring.basic.MessageBean;
import com.spring.basic.MessageBeanEn;
import com.spring.basic.SamsungTV;

@Configuration //������Ʈ�� ���õ� ���� ����
public class Config {
	
	
	 @Bean
	  public MessageBean messageBean() {
		  //	  <bean id="messageBean" class="com.spring.basic.MessageBeanEn"/> ��ü
		  return new MessageBeanEn();
	  }
	  
	 @Bean
	  public LgTV lg(){
		  //  <bean id="lg" class="com.spring.basic.LgTV"/>
		  return new LgTV();
	  }
	  
	 @Bean
	 public SamsungTV samsung() {
		 //	  <bean id="samsung" class="com.spring.basic.SamsungTV"/>
		 return new SamsungTV();
	 }
}
