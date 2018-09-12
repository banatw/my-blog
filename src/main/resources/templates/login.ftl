<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link href="../bootstrap-assets/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-4 col-md-4 col-lg-push-4">
				<#if warning??>
				<div class="alert alert-danger alert-dismissable" >
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>${warning}</strong>
				</div>
				</#if>
				<div class="panel panel-default">
					<div class="panel-body">
						<form method="post" action="/login" >
							<div class="form-group">
								<label for="username">Username</label> <input type="text"
									id="username" name="username" class="form-control" autocomplete="off">
							</div>
							<div class="form-group">
								<label for="password">Password</label> <input type="password"
									id="password" name="password" class="form-control">
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
							<button type="submit" class="btn">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../bootstrap-assets/js/jquery-1.10.2.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../bootstrap-assets/js/bootstrap.min.js"></script>
</body>
</html>