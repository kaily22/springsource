package com.spring.book;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.BookVO;
import com.spring.service.BookService;
import com.spring.service.BookServiceImpl;

public class BookClient {

	public static void main(String[] args) {
		
//		BookService service = new BookServiceImpl();
//		BookVO vo =service.getRow(1000);
//		
//		System.out.println(vo);
		
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		BookService service = (BookService) ctx.getBean("service");
		
		
		//�Է�
		
		BookVO vo = new BookVO();
		vo.setCode(1100);
		vo.setTitle("SPRING ����");
		vo.setWriter("�̽¹�");
		vo.setPrice(31000);
		System.out.println(service.insert(vo)?"����":"����");
		System.out.println("--------------------------------------------------------------");
		
		//����
		BookVO update = new BookVO();
		update.setCode(1100);
		update.setPrice(32111);
		System.out.println(service.update(vo)?"����":"����");
		System.out.println("--------------------------------------------------------------");
		
		//����
		System.out.println(service.delete(1004)?"����":"����");
		System.out.println("--------------------------------------------------------------");
		
		//���� ���� �ϳ� ��������
		System.out.println(service.getRow(1003));
		System.out.println("--------------------------------------------------------------");
		
		
		//��ü ����Ʈ
		List<BookVO> list = service.getList();
		
		
		for(BookVO vo1 : list) {
			System.out.println(vo1);
		}
	}

}
