<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//한글 인코딩 처리
	request.setCharacterEncoding("utf-8");


	//info2.jsp에서 사용자 입력값 가져오기
	String  userid=request.getParameter("userid");
	String  password=request.getParameter("password");
	
	
	//request 영역에 담기
	request.setAttribute("userid_req", userid);
	
	//forward
	pageContext.forward("member2.jsp");
	
%>







