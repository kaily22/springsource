<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<style>	
	.container{
		margin-top: 50px;
	}
</style>
</head>
<body>
<div class="container">
<form action="info_result.jsp" method="post">
  <div class="form-group">
    <label for="userid">ID</label>
    <input type="text" class="form-control" name="userid" id="userid" aria-describedby="idHelp">
    <small id="idHelp" class="form-text text-muted">아이디를 입력해 주세요</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
  </div>  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>