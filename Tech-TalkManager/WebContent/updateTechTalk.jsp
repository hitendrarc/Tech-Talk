<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration Form</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">



<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">
</head>
<body>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>
							<strong>Atmecs</strong>Tech-Talk
						</h1>

					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<!-- <h3>Login to our site</h3> -->
								<p>Enter your information to update:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-key"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="TechTalkController" method="post"
								class="login-form">
								<div class="form-group">
									<label class="sr-only" for="form-username">Title</label> <input
										type="text" name="title" value="${tt.getTitle()}"
										placeholder="Title.." class="form-username form-control"
										id="form-username" required>
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-username">Description</label>
									<input type="text" name="description"
										value="${tt.getDescription()}" placeholder="Description..."
										class="form-username form-control" id="form-username">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Presenter</label> <input
										type="text" name="presenter" value="${tt.getPresentor()}"
										class="form-password form-control" id="form-password">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Date</label> <input
										type="date" name="date" value="${tt.getDate()}"
										placeholder="Date..." class="form-password form-control"
										id="form-password">
								</div>
								<button type="submit" class="btn" name="update" value="update">Update!</button>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/scripts.js"></script>
	<script type="text/javascript">
		
	</script>


</body>
</html>