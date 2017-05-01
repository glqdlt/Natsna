<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Natsna</title>
<style type="text/css">
.pageination {
	overflow: auto;
	
}

.pageination li {
 list-style:none;
 margin-right: 10px;
	float: left;
}
</style>


<%@ include file="../common/header.jsp"%>

<div class="box-body">
	<select name="searchType">
	

		<option value="n"
			<c:out value="${cri.searchType == null?'selected':'' }"/>> --- </option>
		<option value="tcw"
			<c:out value="${cri.searchType == 'tcw'?'selected':'' }"/>>All</option>
			
		<option value="t"
			<c:out value="${cri.searchType == 't'?'selected':'' }"/>>Title</option>
		<option value="c"
			<c:out value="${cri.searchType == 'c'?'selected':'' }"/>>Content</option>
		<option value="w"
			<c:out value="${cri.searchType == 'w'?'selected':'' }"/>>Writer</option>
		<option value="tc"
			<c:out value="${cri.searchType == 'tc'?'selected':'' }"/>>Title&Content</option>
		<option value="cw"
			<c:out value="${cri.searchType == 'cw'?'selected':'' }"/>>Content&Writer</option>

	</select> <input type="text" name="keyword" id="keywordInput"
		value="${cri.keyword }">
	<button id="searchBtn"class="btn btn-primary">Search</button>
	<button id="newBtn"class="btn btn-primary">New Board</button>
</div>


<table class="table table-borderd">

	<tr>
		<th style="width: 10px">NO</th>
		<th>TITLE</th>
		<th>WRITER</th>
		<th>Regdate</th>
		<%--<th style="width: 40px">VIEWCNT</th> --%>
	</tr>

	<c:forEach items="${list}" var="boardVO">

		<tr>


			<td>${boardVO.bno}</td>
			<%--				<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>--%>
			<td><a
				href='/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page) }&bno=${boardVO.bno}'>${boardVO.title }</a></td>
			<%--<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td> --%>
			<td>${boardVO.writer}</td>
			<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
					value="${boardVO.regdate}" /></td>
			<%--<td><span class="badge bg-red">${boardVO.viewcnt}</span></td> --%>
		</tr>


	</c:forEach>

</table>


<div class="text-center">
	<ul class="pageination">

		<c:if test="${pageMaker.prev }">
			<li><a
				href="list${pageMaker.makeSearch(pageMaker.startPage -1 )}">prev</a></li>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="idx">
			<li
				<c:out value="${pageMaker.cri.page == idx?' class =active':'' }"/>>
				<a href="list${pageMaker.makeSearch(idx) }">${idx }</a>
			</li>
		</c:forEach>
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1 )}">next</a></li>
		</c:if>

	</ul>
</div>


<script type="text/javascript">
	var result = '${msg}';

	if (result == 'success') {
		alert('처리가 완료되었습니다.');
	}
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$('#searchBtn').on(
						"click",
						function(event) {
							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $('select option:selected').val()
									+ "&keyword=" + $('#keywordInput').val();

						});
				$('#newBtn').on("click", function(evt) {
					self.location = "register";
				})
			})
</script>
</body>
</html>