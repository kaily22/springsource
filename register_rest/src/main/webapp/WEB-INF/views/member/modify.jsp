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
<form id="modifyForm" action="" method="post">
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
   <input type="hidden"  name="userid" value="${login.userid}"/>   
</form>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script>
$(function(){
   $(".btn-primary").click(function(e){
      e.preventDefault();
      
      let param={
            userid:$("input[name='userid']").val(),
            current_password:$("#current_password").val(),
            new_password:$("#new_password").val(),
            confirm_password:$("#confirm_password").val()
      }
      
      $.ajax({
         url:"../changepwd2",
         type:"put",
         contentType:"application/json",
         data:JSON.stringify(param),
         success:function(data){
            if(data=='success'){
               alert('비밀번호 변경에 성공하였습니다.\n 다시 로그인해 주세요');
               location.href="/";
            }
         },
         error:function(xhr,textStatus,error){
            if(xhr.responseText==='not-equal'){
               alert("비밀번호가 일치하지 않습니다.");
               $("#new_password").val("");
               $("#confirm_password").val("");
            }else
               alert('비밀번호 변경에 실패하였습니다.');
            }
         })
      })
   })

</script>
</body>
</html>