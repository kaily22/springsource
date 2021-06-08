<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사칙연산</h1>
	<form action="" method="post">
		<div>
			<input type="text" name="num1" id="num1" /> 
			<select name="op" id="">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select> 
			<input type="text" name="num2" id="num2" />
		</div>
		<div>
			<input type="submit" value="전송" />
		</div>
		<input type="hidden" name="page" value="3" />
	</form>
	<h2>사용자 입력값</h2>
	<ul>
		<li>num1 : ${calcVO.num1}</li>
		<li>num2 : ${calcVO.num2}</li>
		<li>op : ${calcVO.op}</li>
		<li>page : ${page}</li>
	</ul>
</body>
</html>