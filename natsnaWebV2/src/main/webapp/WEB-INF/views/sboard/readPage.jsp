<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Natsna</title>



<%@ include file="../common/header.jsp"%>

	<form role="form" method="post">
		<input type='hidden' name='bno' value="${boardVO.bno}"> <input
			type='hidden' name='page' value="${cri.page}"> <input
			type='hidden' name='perPageNum' value="${cri.perPageNum}"> <input
			type='hidden' name='searchType' value="${cri.searchType}"> <input
			type='hidden' name='keyword' value="${cri.keyword}">

	</form>

	<div class="form-group">
		<div class="box-body">
			<label for="exampleInputEmail1">Title</label> <input type="text"
				name="title" class="form-control" value="${boardVO.title }"
				readonly="readonly">
		</div>
	</div>
	<div class="form-group">
		<div class="exampleInputPassword1">Content</div>
		<textarea rows="3" name="content" class="form-control"
			readonly="readonly">${boardVO.content}</textarea>
	</div>
	<div class="form-group">
		<label for="exampleInputEmail">Writer</label> <input type="text"
			name="writer" class="form-control" readonly="readonly"
			value="${boardVO.writer }">
	</div>

	<div class="box-footer">
	<c:if test="${login.userid == boardVO.writer}">
		<button type="button" class="btn btn-warning">Modify</button>
		<button type="button" class="btn btn-danger">REMOVE</button>
		</c:if>
		<button type="button" class="btn btn-primary">LIST ALL</button>
	</div>



	<div class="text-center">
		<ul id="pagination" class="pagination pagination-sm no-margin"></ul>
	</div>


<script type="text/javascript">


	var bno = ${boardVO.bno};

	

	$(document)
			.ready(
					function() {
						var formObj = $("form[role='form']");

						$(".btn-warning").on("click", function() {
							formObj.attr("action", "/sboard/modifyPage");
							formObj.attr("method", "get");
							formObj.submit();
						})
						$(".btn-danger").on("click", function() {
							formObj.attr("action", "/sboard/removePage");
							formObj.submit();
						})
						$(".btn-primary").on("click", function() {
							formObj.attr("method", "get");
							formObj.attr("action", "/sboard/list");
							formObj.submit();
						})

					})
</script>
</body>
</html>