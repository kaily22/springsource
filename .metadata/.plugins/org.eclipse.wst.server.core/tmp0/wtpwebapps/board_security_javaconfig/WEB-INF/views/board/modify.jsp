<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>
<link rel="stylesheet" href="/resources/dist/css/attach.css" />
<div class="row">
   <div class="col-lg-12">
      <h1 class="page-header">Board Modify</h1>
   </div>
   <!-- /.col-lg-12 -->
</div>
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
         <div class="panel-heading">Board Modify Page</div>
         <!-- /.panel-heading -->
         <div class="panel-body">
            <form action="" method="post" role="form">
               
               <div class="form-group">
                  <label>Bno</label> <input class="form-control" name="bno"
                     readonly="readonly" value="${vo.bno}">
               </div>
               <div class="form-group">
                  <label>Title</label> <input class="form-control" name="title"
                     value="${vo.title}">
               </div>
               <div class="form-group">
                  <label>Content</label>
                  <textarea class="form-control" rows="3" name="content">${vo.content}</textarea>
               </div>
               <div class="form-group">
                  <label>Writer</label> <input class="form-control" name="writer" readonly="readonly" value="${vo.writer}">
               </div>
               
               <!-- spring security 추가 -->
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />                
                <sec:authentication property="principal" var="info"/>
                <sec:authorize access="isAuthenticated()"><%--로그인 여부 확인--%>
                    <c:if test="${info.username==vo.writer}"><!--로그인한 사용자와 작성자가 동일여부 확인  -->
                          <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
                          <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
                    </c:if>
                </sec:authorize>             
          
               <button type="submit" data-oper='list' class="btn btn-info">List</button>
            </form>
         </div>
      </div>
   </div>
</div>
<%-- 첨부파일 목록 보여주기 --%>
<div class="row">
   <div class="col-lg-12">
      <div class="panel panel-default">
         <div class="panel-heading">
            File 첨부
            </div>
            <div class="panel-body">
               <div class="form-group uploadDiv">
                  <input type="file" name="uploadFile" multiple />
               </div>
               <div class="uploadResult">
                  <ul></ul>
               </div>
            </div>
         </div>
      </div>
   </div>
<%-- remove와 list를 위한 폼--%>
<form action="" id="operForm" method="post">
   <input type="hidden" name="type" value="${cri.type}" /> <input
      type="hidden" name="keyword" value="${cri.keyword}" /> <input
      type="hidden" name="pageNum" value="${cri.pageNum}" /> <input
      type="hidden" name="amount" value="${cri.amount}" /> <input
      type="hidden" name="bno" value="${vo.bno}" />
      
    <%--spring security 추가--%>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="hidden" name="writer" value="${vo.writer}">
</form>
<%-- 스크립트 --%>
<script>   
   let bno=${vo.bno};
   var csrfHeaderName = "${_csrf.headerName}";
   var csrfTokenValue = "${_csrf.token}";
</script>
<script src="/resources/js/modify.js"></script>
<%@include file="../includes/footer.jsp"%>