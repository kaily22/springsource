package com.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.spring.domain.LoginVO;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("pre Handle");
		
		//http://localhost:8081/member/change-pwd => 로그인 정보가 있는지?
		HttpSession session = request.getSession();
		
		LoginVO login = (LoginVO)session.getAttribute("login");		
		if(login != null) { //세션 정보가 있음
			return true;
		}
			//세션값이 없다면 로그인 페이지로 이동
			response.sendRedirect("/member/login");
			return false;
		}
}
