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
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Register</h3>
					</div>
					<div class="panel-body">
						<form action="/user/register" method="post">
							<fieldset>
								<div class="form-group has-feedback">
									<input type="text" name="userid" class="form-control"
										placeholder="User ID" />
								</div>
								<div class="form-group has-feedback">
									<input type="password" name="userpw" class="form-control"
										placeholder="Password" />
								</div>
								
								<div class="form-group has-feedback">
									<input type="text" name="username" class="form-control"
										placeholder="User Name" />
								</div>
								<div class="form-group has-feedback">
									<input type="text" name="email" class="form-control"
										placeholder="Your Email" />
								</div>
								
								<button type="submit"
									class="btn btn btn-primary btn-block btn-flat">Join</button>

								<button type="button" id="cancleBtn"
									class="btn btn btn-info btn-block btn-flat">Cancle</button>

							</fieldset>
						</form>
					</div>
				</div>
			</div>
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