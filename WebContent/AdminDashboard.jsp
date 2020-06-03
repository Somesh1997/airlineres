<%@ page session="true" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<style>
<!--
Navbar -->.w3-black, .w3-hover-black:hover {
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

<!-- Datepicker CSS -->
<link rel="stylesheet" href="static/css/wbn-datepicker.css">

</head>

<body
	style="background-image: url('images/AdminDashboard.jpg'); background-size: cover; background-repeat: no-repeat; background-attachment: fixed; background-position: center; height: 100%">

	<!-- Session template -->
	<%
		if (session.getAttribute("uname") != null && (int) session.getAttribute("isAdmin") == 2) {
	%>

	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: #0f84f2;"
				href="AdminDashboard.jsp"> <img src="images/Flight.png"
					width="40" height="40"> SAVAN Airlines
			</a>
			</span>
		</div>
	</div>

	<br>
	<br>
	<br>


	<c:set var="ncan" scope="request" value="${ res }" />
	<c:if test="${ requestScope.ncan != null }">
		<div class="container">
			<div class="alert alert-success alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;">Flight deleted
					successfully</strong>Have a good day
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<c:set var="ures" scope="request" value="${ updateres }" />
	<c:if test="${ requestScope.ures != null }">
		<div class="container">
			<div class="alert alert-success alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;">Flight updated
					successfully</strong>For more updation go to flight operation
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<c:set var="ures" scope="request" value="${ addresfail }" />
	<c:if test="${ requestScope.ures != null }">
		<div class="container">
			<div class="alert alert-success alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;">Server Error 500</strong>Flight
				not added, try after some time
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<c:set var="ures" scope="request" value="${ addres }" />
	<c:if test="${ requestScope.ures != null }">
		<div class="container">
			<div class="alert alert-success alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;">Flight added
					successfully</strong>For more addition go to flight operation
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>



	<div class="col-md-4" style="display: inline-block; padding: 20px">
		<div class="card" style="width: 20rem;">
			<img src="images/Image1.jpg" class="card-img-top">
			<div class="card-body">
				<h4 class="card-title" style="color: #0f84f2">
					Hello
					<c:out value="${sessionScope.fname }"></c:out>
				</h4>
				<br>
				<h5 class="card-title">Personal Operations</h5>
			</div>

			<ul class="list-group list-group-flush">
				<li class="list-group-item"><a href="#" class="card-link">Edit
						Details</a></li>
				<li class="list-group-item"><a href="ChangePasswordAdmin.jsp"
					class="card-link">Change Password</a></li>
				<li class="list-group-item"><a href="LogoutController"
					class="card-link">Log Out</a></li>
			</ul>

			<div class="card-body">
				<h5 class="card-title">Manipulation Operations</h5>
			</div>

			<ul class="list-group list-group-flush">
				<li class="list-group-item"><a href="FlightOperationController"
					class="card-link">Flight Operations</a></li>
				<li class="list-group-item"><a
					href="PassengerDetailsController" class="card-link">Passenger
						Details</a></li>
			</ul>

		</div>
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
	<!-- Date Picker -->
		var date = $('#departure').datepicker({
			dateFormat : 'dd-mm-yy'
		}).val();

		$(document).ready(function() {

			$('#departure').datepicker({
				yearRange : '1950:2019',
				minDate : new Date(),
				maxDate : "+1M"
			});

		});
	</script>

	<!-- Session template -->
	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>

</body>
</html>