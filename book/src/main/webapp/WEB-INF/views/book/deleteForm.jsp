<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="delete" method="post">
	<div class="form-group">
		<label for="code">Code</label> <input type="text" name="code"
			id="code" placeholder="코드 입력" required class="form-control" />
	</div>
	<div>
		<button type="submit" class="btn btn-danger">삭제</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>
</form>