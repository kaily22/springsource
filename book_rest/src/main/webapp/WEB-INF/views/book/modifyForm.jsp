<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="update" method="post">
	<div class="form-row">
		<div class="form-group col-6">
			<input type="text" name="code" id="code" placeholder="코드 입력"
				required class="form-control"/>
		</div>
		<div class="form-group col-6">
			<input type="text" name="price" id="price" placeholder="변경 가격 입력"
				required class="form-control" />
		</div>
	</div>
	<div>
		<button type="submit" class="btn btn-primary">수정</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>
</form>