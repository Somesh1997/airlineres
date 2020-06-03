<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Alata&display=swap"
	rel="stylesheet">
<style>
.w3-black, .w3-hover-black:hover {
	color: black !important;
	background-color: rgba(255, 99, 71, 0) !important
}

.w3-bar .w3-bar-item-left {
	padding-left: 10px;
	float: left;
	width: auto;
	border: none;
	display: block;
	outline: 0;
	color: #9BE0F7
}

.w3-bar .w3-bar-item {
	padding: 8px 16px;
	float: right;
	width: auto;
	border: none;
	display: block;
	outline: 0
}

.w3-bar .w3-dropdown-hover, .w3-bar .w3-dropdown-click {
	position: static;
	float: left
}

.w3-bar .w3-button {
	white-space: normal
}

.w3-bar-block .w3-bar-item {
	width: 100%;
	display: block;
	padding: 8px 16px;
	text-align: left;
	border: none;
	white-space: normal;
	float: none;
	outline: 0
}

.w3-bar-block.w3-center .w3-bar-item {
	text-align: center
}

.w3-block {
	display: block;
	width: 100%
}

.w3-bar-item.w3-mobile, .w3-dropdown-hover.w3-mobile, .w3-dropdown-click.w3-mobile
	{
	text-align: center
}

.w3-green, .w3-hover-green:hover {
	color: #fff !important;
	background-color: #9BE0F7 !important;
}
</style>

<title>SAVAN Airlines</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css">

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body
	style="font-family: Alata; background-image: url('images/LoginBg.jpg'); background-size: cover; background-repeat: no-repeat; background-attachment: fixed; background-position: center; height: 100%">

	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: white;"
				href="HomePage.html"> <img src="images/Flight.png" width="40"
					height="40"> SAVAN Airlines
			</a>
			</span>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a style="text-decoration: none; color: white;" href="ContactUs.jsp"><i
				class="fa fa-phone-square" aria-hidden="true"></i> Contact Us </a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a style="text-decoration: none; color: white;" href="WebCheckIn.jsp"><i
				class="fa fa-wifi" aria-hidden="true"></i> Web Check-in </a>
		</div>
		<div class="w3-bar-item w3-hover-green">
			<a style="text-decoration: none; color: white;" href="Login.jsp">
				<i class="fa fa-sign-in" aria-hidden="true"></i> Login
			</a>
		</div>
		<div class="w3-bar-item w3-hover-green ">
			<a style="text-decoration: none; color: white;" href="SignUp.jsp">
				<i class="fa fa-user-plus" aria-hidden="true"></i> Sign Up
			</a>
		</div>
	</div>

	<br>
	<br>
	
	<c:set var="cred" scope="request" value="${ credentials }"/>
	<c:if test="${ requestScope.cred != null }">
		<div class="container" style="padding-left: 22%">
			<div class="alert alert-danger alert-dismissible fade <c:out value="show"></c:out> col-md-8" role="alert">
				<strong style="padding-right: 10px;">Error!</strong> Please Enter
				correct credentials.
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<br>

	<div class="col-md-5"
		style="border: 1px solid white; margin: auto; width: 50%; border-radius: 10px; background-color: white; padding: 20px;">
		<form action="LoginController" method="POST">
			<h3 style="text-align: center; color: dodgerblue">LOGIN</h3>
			<br>
			<div class="form-group">
				<label for="exampleInputEmail1">User ID</label> <input type="text"
					class="form-control" name="username" id="exampleInputEmail1"
					aria-describedby="emailHelp" maxlength="20" minlength="4"
					placeholder="Enter User ID" autofocus required> <small
					id="userId" class="form-text text-muted">We'll never share
					your ID with anyone else.</small>
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" name="password" class="form-control" id="exampleInputPassword1"
					placeholder="Password" maxlength="16" minlength="8" required>
			</div>

			<br>

			<button style="margin-left: 43%" type="submit"
				class="btn btn-primary">Login</button>

			<br>
			<br>

			<div class="form-group" style="text-align: center">
				New User? <a href="SignUp.jsp"
					style="display: inline-block; text-decoration: none">Sign Up
					Here...</a>
			</div>
		</form>
	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	<!-- Datepicker Js -->
	<script src="static/js/wbn-datepicker.min.js"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict';
			window.addEventListener('load',
					function() {
						// Fetch all the forms we want to apply custom Bootstrap validation styles to
						var forms = document
								.getElementsByClassName('needs-validation');
						// Loop over them and prevent submission
						var validation = Array.prototype.filter.call(forms,
								function(form) {
									form.addEventListener('submit', function(
											event) {
										if (form.checkValidity() === false) {
											event.preventDefault();
											event.stopPropagation();
										}
										form.classList.add('was-validated');
									}, false);
								});
					}, false);
		})();

		var date = $('#departure').datepicker({
			dateFormat : 'dd-mm-yy'
		}).val();

		$(document).ready(function() {

			$('#departure').datepicker({
				yearRange : '1950:2013',
				minDate : new Date(),
				maxDate : "+1M"
			});

		});
	</script>

</body>
</html>