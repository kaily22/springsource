package com.company.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.annotation.user.UserDAO;
import com.company.annotation.user.UserDO;

@Controller
public class LogoutController{
	
	@RequestMapping("/logout.do")
	public String login(UserDO userDO, UserDAO userDAO, HttpSession session) {
		
		UserDO user = userDAO.getUser(userDO);
		session.invalidate();
		
		
		return "login.jsp";
	}
	
}
