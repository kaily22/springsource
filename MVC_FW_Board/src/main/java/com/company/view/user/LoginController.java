package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.MVC_FW_Board.user.UserDAO;
import com.company.MVC_FW_Board.user.UserDO;
import com.company.view.controller.Controller;

public class LoginController implements Controller{
	
	//������
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
		
		//1. ����� �Է� ���� ����
		String id=request.getParameter("id");
		String password = request.getParameter("password");
		
		//2. �� �� ó��
		UserDO userDO = new UserDO();
		userDO.setId(id);
		userDO.setPassword(password);
		
		UserDAO userDAO = new UserDAO();
		UserDO user = userDAO.getUser(userDO);
		
		//3. ������
		if(user != null) {
			//�α��� ����ó�� ����!
			HttpSession session = request.getSession();
			session.setAttribute("IdKey", id);
			return "getBoardList.do";
		}else { //�α��� ����ó�� ����!!
			return "login" ; //�տ� ���λ� -> "./login.jsp" -> viewName�� ���� -> login
		}
	}
}