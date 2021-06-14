<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h3>도서정보</h3>
		<button type="button" id="get">도서 전체 목록 가져오기</button>
		<button type="button" id="code">개별 도서 정보 가져오기</button>
		<button type="button" id="remove">도서 정보 삭제</button>
		<button type="button" id="update">도서 정보 수정</button>
		
		<div id="result">
		 <table class="table">
		 
		 </table>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
	$(function(){
		$("#get").click(function(){
			$.getJSON({
				url:'/rest_list',
				contentType : 'application/json;charset=utf-8',
				success:function(data){
					console.log(data);
					
					let str = "";
					
					$.each(data,function(idx,element){
						str += "<tr>";
						str += "<td>"+element.code+"</td><td>" +element.title+"</td>";
						str += "<td>"+element.writer+"</td><td>" +element.price+"</td>";
						str += "</tr>";
					})
// 					$(data).each(function(idx,element){
						
// 					});
					
					$("#result table").html(str);
				}
			})
		})
	$("#code").click(function(){
			$.getJSON({
				url:'/1002',
				contentType : 'application/json;charset=utf-8',
				success:function(element){
					console.log(element);
					
					let str = "";
					
						str += "<tr>";
						str += "<td>"+element.code+"</td><td>" +element.title+"</td>";
						str += "<td>"+element.writer+"</td><td>" +element.price+"</td>";
						str += "</tr>";
						
					$("#result table").html(str);
				}
			})
		})
		$("#remove").click(function(){
			$.ajax({
				url:'/1100',
				type : 'delete',
				success:function(element){
					console.log(element);
					
					$("#result table").html(str);
				},
				error : function(xhr, txtStatus, error){
					$("#result table").html(xhr.responseText);
				}
			})
		})
		$("#update").click(function(){
			
			//자바 스크립트
			let param = {
				code:1103,
				price:12000
			}
			
			//JSON.stringify() : client 측에서 서버로 데이터를 보낼 때 사용
			//자바 스크립트 객체를 json 형태로 변환시켜서 전송
			
			$.ajax({
				url:'/update',
				type : 'put',
				contentType:"application/json",
				data:JSON.stringify(param),
				success:function(data){
					console.log(data);
					
					$("#result table").html(data);
				},
				error : function(xhr, txtStatus, error){
					$("#result table").html(xhr.responseText);
				}
			})
		})
	})
	</script>
</body>
</html>