<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="insert" method="post">
	<div class="form-group">
		<label for="code">Code</label>
		<input type="text" name="code" id="code" placeholder="코드 입력" 
		required class="form-control"/>
	</div>	
	<div class="form-group">
		<label for="title">Title</label>
		<input type="text" name="title" id="title" placeholder="제목 입력" required class="form-control"/>
	</div>	 
	<div class="form-group">
		<label for="writer">Writer</label>
		<input type="text" name="writer" id="writer" placeholder="작가 입력" required class="form-control"/>
	</div>	 
	<div class="form-group">
		<label for="price">Price</label>
		<input type="text" name="price" id="price" placeholder="가격 입력" required class="form-control"/>
	</div>	
	<div>
		<button type="submit" class="btn btn-primary">입력</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>       	
</form>