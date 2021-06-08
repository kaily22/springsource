<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<p>
	<!-- controller에 있는 주소로 넣어줘야함 -->
		<a href="/board/insert">insert</a>
		<a href="/board/update">update</a>
		<a href="/board/remove">remove</a>
		<a href="/board/read">read</a>
		</p>
<p>${age}</p> <%--RedirectAttribute 객체 addFlashAttribute 사용 --%>
<p><%=request.getParameter("age1") %></p> <%--RedirectAttribute 객체 addFlashAttribute 사용 --%>
</body>
</html>
