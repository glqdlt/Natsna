<%@page import="org.springframework.web.multipart.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Natsna</title>
<link rel="icon" type="image/png" href="/img/favicon.png">
<link href="/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

</head>
<body>


	<div class="container">
		<div class="row">
		
		<h1>업로드 용량은 50MB를 넘길수가 없습니다.</h1>

								<button type="button" id="cancleBtn"
									class="btn btn btn-info btn-block btn-flat">Return Home</button>

		</div>
	</div>


	<script src="/vendor/jquery/jquery.min.js"></script>
	<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="/vendor/metisMenu/metisMenu.min.js"></script>
	<script src="/dist/js/sb-admin-2.js"></script>
	<script type="text/javascript">
		$("#cancleBtn").click(function() {
			location.href = '/';
		});
	</script>

</body>
</html>