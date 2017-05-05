
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
		<div class="col-sm-1 col-sm-offset-0 text">

			<h1>
				<strong>${username}</strong>
			</h1>

		</div>


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
					<div class="col-sm-8 col-sm-offset-2 form-box">
						<div class="form-top">

							<div class="form-top-right">
								<!-- <i class="fa fa-key"></i> -->
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="adminHome" method="post"
								class="login-form">
								<div class="form-group">
									<table class="table table-inverse">
										<thead>
											<tr>
												<th>Date</th>
												<th>Title</th>
												<th>Description</th>
												<th>Presenter</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${tt}" var="item">
												<tr>

													<td>${item.getDate()}</td>
													<td>${item.getTitle()}</td>
													<td>${item.getDescription()}</td>
													<td>${item.getPresentor()}</td>


													<td><input type="hidden" name="field1"
														value="${username}"> <input type="hidden"
														name="field2" value="${item.getTitle()}">
														<button type="submit" class="btn" name="delete"
															value="${item.getTitle()}">Delete</button></td>
													<td><button type="submit" class="btn" name="update"
															value="${item.getId()}">Update</button></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
									<div>
										<table>
											<tbody>
												<tr>
													<td>
														<button type="submit" class="btn" name="add" value="add">Add
															TechTalk</button>
													</td>
													<td><label> </label></td>
													<td></td>
													<td>
														<button type="submit" class="btn" name="users"
															value="users">Registered Users</button>
													</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>

								<button type="submit" class="btn" name="logout" value="logout">Logout!</button>
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



</body>
</html>