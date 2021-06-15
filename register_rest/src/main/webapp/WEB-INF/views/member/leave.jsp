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
<form id="leaveform" action="" method="post">
	<div class="card"  style="width: 40rem;margin:40px auto;">	
		<div class="card-header">
	    	<h4>회원탈퇴</h4>
	  	</div>
	 	<div class="card-body">	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="text" name="userid" id="userid" class="form-control" value="${login.userid}" readonly/>
			 		<small id="userid" class="text-info"></small>		
				</div>
			</div>	
			<div class="form-group row justify-content-center">		
				<div class="col-sm-10">	
					<input type="password" name="current_password" id = "current_password" class="form-control" placeholder="비밀번호" autofocus="autofocus"/>
					<small id="current_password" class="text-info"></small>
				</div>	
			</div>				
			<div class="form-group text-center">		
				<button type="submit" class="btn btn-primary">탈퇴</button>
			    <button type="button" class="btn btn-secondary" id="leavecancel">취소</button>		
			</div>
		</div>
	</div>	
</form>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
$(function(){
	$(".btn-primary").click(function(e){
		e.preventDefault();
		
		let param ={
			userid:$("input[name='userid']").val(),
			current_password:$("#current_password").val()
		}
		
		$.ajax({
			url:"../leave2",
		    type:"delete",
		    contentType:"application/json",
		    data:JSON.stringify(param),
		    success:function(data){
		    	if(data=='success'){
		    		alert('회원정보가 삭제 되었습니다.');
		    	    location.href = "/";
		    	}
		    },
		    error:function(xhr,textStatus,error){
		    		alert('비밀번호가 틀립니다.');
		    		$("#current_password").select(); //블록잡아줌
		    	}
		})
		
	})
})
</script>
</body>
</html>