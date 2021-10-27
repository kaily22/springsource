package com.company.view.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//��ü �������� ����(�������)
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	//�������� �ʿ� �޼ҵ� �������̵� ��Ű�� ��� => ���� i �Է��ϰ� ctrl+space
	@Override
	public void init() throws ServletException {
		
		//������ �����̳ʰ� init() ȣ�� 
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
    public DispatcherServlet() {
        super();
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		process(request,response);
}
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//1.Ŭ���̾�Ʈ�� ��û path ���� ���
		// (��) "http://localhost:8080/MVC_FW_Board/login.do" ��û�� �����Ͽ�
		String uri = request.getRequestURI(); //"MVC_FW_Board/login.do"�� ����
		int lastposition = uri.lastIndexOf("/"); //13�� ����!
		String filePath = uri.substring(lastposition); //"/login.do"�� ����!
		
		//2.HandlerMapping�� ���ؼ� filePath�� �ش��ϴ� Controller�� �˻��Ѵ�.
		Controller ctrl = handlerMapping.getController(filePath);
		
		//3.�˻��� Controller�� �����Ѵ�.
		String viewName = ctrl.handleRequest(request, response);
		
		//4. viewResolver�� ���ؼ� viewName�� �ش��ϴ� ������(������)�� �˻��Ѵ�.
		String view = null;
		
		//�α��� �����ÿ��� "getBoardList.do" ���ڿ��� �Ѿ����,
		//���� �ÿ��� "login"�� �Ѿ��
		
		if(viewName.contains(".do")) {
			view = viewName;
			
		}else {
			view = viewResolver.getView(viewName);
		}
		
		//5.������ ������
		response.sendRedirect(view);
		
		
	}

}