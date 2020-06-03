<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	background-color: white !important;
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

<!-- Datepicker CSS -->
<link rel="stylesheet" href="static/css/wbn-datepicker.css">

</head>

<body
	style="font-family: Alata; background-image: url('images/ChangePassword.jpg'); background-size: cover; 
	background-repeat: no-repeat; background-attachment: fixed; background-position: center; height: 100%">
	
	<!-- Session template -->
	<%
		if(session.getAttribute("uname") != null && (int)session.getAttribute("isAdmin") == 1){
	%>

	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: #1dc44a;"
				href="CustomerDashboard.jsp"> <img src="images/Flight.png" width="40"
					height="40"> SAVAN Airlines
			</a>
			</span>
		</div>
	</div>
	
	<a class="pr-4" href="CustomerDashboard.jsp" style="float: right">
		<button type="button" class="btn btn-outline-success">
			<i class="fa fa-chevron-circle-left" aria-hidden="true"></i> Back
		</button>
	</a>

	<br>
	<br>
	<br>
	<br>
	
	<c:set var="succ" scope="request" value="${ success }"/>
	<c:if test="${ requestScope.succ != null }">
		<div class="container" style="padding-left: 22%">
			<div class="alert alert-success alert-dismissible fade <c:out value="show"></c:out> col-md-8" role="alert">
				<strong style="padding-right: 10px;">Success!</strong> Password changed successfully.
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		
	</c:if>
	
	<c:set var="err" scope="request" value="${ error }"/>
	<c:if test="${ requestScope.err != null }">
		<div class="container" style="padding-left: 22%">
			<div class="alert alert-danger alert-dismissible fade <c:out value="show"></c:out> col-md-8" role="alert">
				<strong style="padding-right: 10px;">Error!</strong> Can't Update password. Please try after some time.
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		
	</c:if>
	
	<c:set var="oldP" scope="request" value="${ oldPass }"/>
	<c:if test="${ requestScope.oldP != null }">
		<div class="container" style="padding-left: 22%">
			<div class="alert alert-danger alert-dismissible fade <c:out value="show"></c:out> col-md-8" role="alert">
				<strong style="padding-right: 10px;">Error!</strong> Old Password not valid.
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		
	</c:if>
	
	<c:set var="wro" scope="request" value="${ mismatch }"/>
	<c:if test="${ requestScope.wro != null }">
		<div class="container" style="padding-left: 22%">
			<div class="alert alert-danger alert-dismissible fade <c:out value="show"></c:out> col-md-8" role="alert">
				<strong style="padding-right: 10px;">Error!</strong> New and confirm password does not match.
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
		
	</c:if>
	
	<div class="col-md-5"
		style="border: 1px solid white; margin: auto; width: 50%; border-radius: 10px; background-color: white; padding: 20px;">
		<form action="ChangePass" method="POST">
			<h3 style="text-align: center; color: dodgerblue">CHANGE PASSWORD</h3>
			<br>
			<div class="form-group">
				<label for="password">Old Password</label> <input
					type="password" class="form-control" id="password"  name="password"
					aria-describedby="password" maxlength="16" minlength="8"
					placeholder="Enter Old Password" autofocus required> <small
					id="password" class="form-text text-muted"> We'll never
					share your password with anyone else.</small>
			</div>
			
			<div class="form-group">
				<label for="confirmPassword">New Password</label> <input
					type="password" class="form-control" id="npassword" name="npassword"
					aria-describedby="npassword" maxlength="16" minlength="8"
					placeholder="Enter New Password" required>
			</div>
			
			<div class="form-group">
				<label for="confirmPassword">Confirm Password</label> <input
					type="password" class="form-control" id="cpassword" name="cpassword"
					aria-describedby="cpassword" maxlength="16" minlength="8"
					placeholder="Confirm New Password" required>
			</div>

			<br>

			<button style="margin-left: 35%" type="submit"
				class="btn btn-primary">Change Password</button>
				
		</form>
	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	<!-- Datepicker Js -->
	<script src="static/js/wbn-datepicker.min.js"></script>

	<script type="text/javascript" src="validate.js"></script>
	
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
	
	<!-- Session template -->
	<%}else{ response.sendRedirect("Login.jsp"); }%>
	
</body>
</html>