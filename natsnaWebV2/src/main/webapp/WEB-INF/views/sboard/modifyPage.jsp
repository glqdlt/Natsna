<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Natsna</title>




<%@ include file="../common/header.jsp"%>
	<form role="form" method="post">
	
	<input type='hidden' name='page' value='${cri.page }'>
	<input type='hidden' name='perPageNum' value='${cri.perPageNum }'>
	<input type='hidden' name='searchType' value='${cri.searchType }'>
	<input type='hidden' name='keyword' value='${cri.keyword }'>
		
		<div class="box-body">
		<label for="exampleInputEmail1">BNO</label>
		<input type='text' name='bno' class="form-control" value="${boardVO.bno}" readonly="readonly">
</div>

	<div class="form-group">
		<div class="box-body">
			<label for="exampleInputEmail1">Title</label> <input type="text"
				name="title" class="form-control" value="${boardVO.title }">
		</div>
	</div>
	<div class="form-group">
		<div class="exampleInputPassword1">Content</div>
		<textarea rows="3" name="content" class="form-control">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail">Writer</label> <input type="text"
			readonly="readonly" name="writer" class="form-control"
			value="${boardVO.writer }">
	</div>

	<div class="box-footer">
		<button type="button" class="btn btn-primary">OK</button>
		<button type="button" class="btn btn-warning">CANCLE</button>
	</div>
	</form>
<script type="text/javascript">
	$(document).ready(function() {
		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-primary").on("click", function() {
			formObj.submit();
		});
		
		
		$(".btn-warning").on("click", function() {
			self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"+
					"&searchType=${cri.searchType}&keyword=${cri.keyword}";
		});

	})
</script>
</body>
</html>