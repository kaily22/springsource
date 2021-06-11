<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</head>
<body>
<div class="jumbotron">
	<h1>Book - 모델1</h1>
</div>
<div class="container-fluid">
	<div class="row">
	  <div class="col-4">
	    <div class="list-group" id="myList" role="tablist">
	      <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#insert" role="tab" aria-controls="home">도서 정보 입력</a>
	      <a class="list-group-item list-group-item-action" id="list-profile-list" data-toggle="list" href="#all" role="tab" aria-controls="profile">도서 목록 보기</a>
	      <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#delete" role="tab" aria-controls="messages">도서 정보 삭제</a>
	      <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#search" role="tab" aria-controls="settings">도서 정보 검색</a>
	      <a class="list-group-item list-group-item-action" id="list-settings-list" data-toggle="list" href="#modify" role="tab" aria-controls="settings">도서 정보 수정</a>
	    </div>
	  </div>
	  <div class="col-8">
	    <div class="tab-content" id="nav-tabContent">
	      <div class="tab-pane fade show active" id="insert" role="tabpanel" aria-labelledby="list-home-list">
	      	<%@include file="book/insertForm.jsp" %>
	      </div>
	      <div class="tab-pane fade" id="all" role="tabpanel" aria-labelledby="list-profile-list">
	      	<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">코 드</th>
			      <th scope="col">제 목</th>
			      <th scope="col">작 가</th>
			      <th scope="col">가 격</th>
			    </tr>
			  </thead>
			  <tbody><%-- 도서 목록 보기 --%>
			  <c:forEach var ="vo" items="${list}">
			    <tr>
			      <td>${vo.code}</td>
			      <td>${vo.title}</td>
			      <td>${vo.writer}</td>
			      <td>${vo.price}</td>
			     </tr>
			  </c:forEach>
			  </tbody>
			</table>
	      </div>
	      <div class="tab-pane fade" id="delete" role="tabpanel" aria-labelledby="list-messages-list">
	      	<%@include file="book/deleteForm.jsp" %>
	      </div>
	      <div class="tab-pane fade" id="search" role="tabpanel" aria-labelledby="list-settings-list">
	      	<%@include file="book/searchForm.jsp" %>
	      </div>
	      <div class="tab-pane fade" id="modify" role="tabpanel" aria-labelledby="list-settings-list">
	      	<%@include file="book/modifyForm.jsp" %>
	      </div>
	    </div>
	  </div>
	</div>
</div>
<script>
$(function(){
	$("#myList a[href='#all']").tab('show');
})
</script>
</body>
</html>








