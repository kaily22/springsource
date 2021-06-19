package com.spring.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FileCheckTask {
	
	/*@Scheduled
	 * ���� Ÿ���� void ���� �ϰ� �Ķ���͸� ���� �ʴ� �޼ҵ忡 ����
	 * cron : CronTab ���� ��İ� �����ϰ� ����
	 * "0 * * * * * " : second, minute, hour, day of month, month, day of week
	 * 
	 * fixedDelay : ������ ����� Task�� ���� �ð����κ��� ���ǵ� �ð� ��ŭ ���� �� Task ����(�и� ������ ����)
	 * fixedRate : ������ ����� Task�� ���� �ð����κ��� ���ǵ� �ð� ��ŭ ���� �� Task ����(�и� ������ ����)
	 * */
	
	
	@Scheduled(cron="0 * * * * *")
	public void schedulerTest() {
		System.out.println("�� �� 1�� ���� �����층 �׽�Ʈ");
		
	}
	
	@Scheduled(fixedDelay = 10000)
	public void schedulerTest2() {
		System.out.println("10�ʸ��� �����층 �׽�Ʈ");
	}

}
