<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Natsna</title>
<%@ include file="../common/header.jsp"%>

	<form role="form" method="post">
		<div class="box-body">
			<div class="form-group">
				<label for="exampleInputEmail1">Title</label> 
				<input type="text"
					name="title" class="form-control" placeholder="Enter Title">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Content</label>
				<textarea rows="3" class="form-control" name="content"
					placeholder="Enter ..."></textarea>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Writer</label> 
				<input type="text"
					name="writer" class="form-control" placeholder="Enter Writer"  readonly="readonly" value="${login.userid}">
			</div>
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>

	</form>


</body>
</html>