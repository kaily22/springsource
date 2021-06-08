<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
</head>
<body>
<form id="modifyform" action="" method="post">
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>비밀번호 변경</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="current_password" id="current_password" class="form-control" placeholder="현재 비밀번호" autofocus="autofocus"/>
					<small id="current_password" class="text-info"></small>	
				</div>
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="new_password" id = "new_password" class="form-control" placeholder="새 비밀번호"/>
					<small id="new_password" class="text-info"></small>
				</div>	
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="confirm_password" id = "confirm_password" class="form-control" placeholder="새 비밀번호 확인"/>
					<small id="confirm_password" class="text-info"></small>
				</div>	
			</div>	
			<div class="form-group text-center">		
				<button type="submit" class="btn btn-primary">수정</button>
			    <button type="reset" class="btn btn-secondary" id="modifycancel">취소</button>		
			</div>
		</div>
	</div>		
</form>
</body>
</html>