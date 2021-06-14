<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="" method="">
	<div class="form-row">
		<div class="form-group col-6">
			<select name="criteria" id="" class="form-control">
				<option value="code">코드</option>
				<option value="writer">작가</option>
			</select>
		</div>
		<div class="form-group col-6">
			<input type="text" name="keyword" id="keyword" placeholder="검색어 입력"
				required class="form-control" />
		</div>
	</div>
	<div>
		<button type="submit" class="btn btn-success">검색</button>
		<button type="reset" class="btn btn-secondary">취소</button>
	</div>
</form>