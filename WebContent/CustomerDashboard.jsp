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
	style="font-family: Alata; background-image: url('images/SearchFlight.jpg'); background-size: cover; background-repeat: no-repeat; background-attachment: fixed; background-position: center; height: 100%">

	<!-- Session template -->
	<%
		if (session.getAttribute("uname") != null && (int) session.getAttribute("isAdmin") == 1) {
	%>

	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: black;"
				href="CustomerDashboard.jsp"> <img src="images/Flight.png"
					width="40" height="40"> SAVAN Airlines
			</a>
			</span>
		</div>
	</div>

	<br>
	<br>
	<br>
	<c:set var="succ" scope="request" value="${ result }" />
	<c:if test="${ requestScope.succ != null }">
		<div class="container">
			<div class="alert alert-success alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;"">Successfully Booked
					Ticket! </strong> Check more info in upcoming journey
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<c:set var="ncan" scope="request" value="${ ncacnel }" />
	<c:if test="${ requestScope.ncan != null }">
		<div class="container">
			<div class="alert alert-danger alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;"">Ticket cancel error</strong>Please
				try after some time
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>

	<c:set var="can" scope="request" value="${ cancel }" />
	<c:if test="${ requestScope.can != null }">
		<div class="container">
			<div class="alert alert-success alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;"">Ticket cancel
					successfully! </strong> To cancel more ticket go inside upcoming journey
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>
	<div class="col-md-2" style="display: inline-block; padding: 20px">
		<div class="card" style="width: 18rem;">
			<img src="images/Image1.jpg" class="card-img-top" alt="...">
			<div class="card-body">
				<h5 class="card-title">
					Hello
					<c:out value="${sessionScope.fname }"></c:out>
				</h5>
			</div>
			<ul class="list-group list-group-flush">
				<li class="list-group-item"><a href="#" class="card-link">Edit
						Details</a></li>

				<li class="list-group-item">
					<form id="form1" action="UpcomingFlightsController" method="post">
						<a href="#" class="card-link"
							onclick="document.getElementById('form1').submit();">Upcoming
							Journeys</a>
					</form>
				</li>

				<li class="list-group-item">
					<form id="form2" action="PastFlightsController" method="post">
						<a href="#" class="card-link"
							onclick="document.getElementById('form2').submit();">Past
							Journeys</a>
					</form>
				</li>

				<li class="list-group-item"><a
					href="ChangePasswordCustomer.jsp" class="card-link">Change
						Password</a></li>

				<li class="list-group-item"><a href="LogoutController"
					class="card-link">Log Out</a></li>
			</ul>
		</div>
	</div>

	<div class="col-md-4"
		style="display: inline-block; border: 1px solid white; border-radius: 10px; background-color: white; padding: 20px; float: right; margin: 20px;">
		<h3 style="padding-bottom: 20px">Book A Flight</h3>
		<form action="SearchFlightController" method="post">
			<div class="form-row" style="padding-bottom: 20px;">
				<div class="form-group  col-md-6 mb-3">
					<label for="from">From</label> 
					<select name="from" class="form-control" id="flightfrom" required>
						<option selected autofocus hidden value="from">From</option>
						<option value="BLR">Bangalore-BLR</option>
						<option value="DEL">Delhi-DEL</option>
						<option value="BOM">Mumbai-BOM</option>
						<option value="CCU">Kolkata-CCU</option>
					</select>
				</div>

				<div class="form-group  col-md-6 mb-3">
					<label for="too">To</label> 
					<select name="too" class="form-control" id="flightto" required>
						<option selected hidden value="to">To</option>
						<option value="BLR">Bangalore-BLR</option>
						<option value="DEL">Delhi-DEL</option>
						<option value="BOM">Mumbai-BOM</option>
						<option value="CCU">Kolkata-CCU</option>
					</select>
				</div>

			</div>


			<div class="form-row" style="padding-bottom: 20px;">
				<div class="col-md-6 mb-3 form-group">
					<label for="departure">Departure Date</label> <input
						placeholder="Departure Date" type="text" id="departure"
						name="departure" class="form-control wbn-datepicker"
						readonly="readonly" required>
					<div class="invalid-feedback">Please provide a valid date.</div>
				</div>

				<div class="form-group col-md-4" style="padding-bottom: 10px">
					<label for="passengers">Passengers</label> <select
						class="form-control" name="passengers" id="passengers">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					</select>
				</div>

				<div class="form-check" style="padding-left: 30px">
					<h5>Class</h5>
					<input class="form-check-input" type="radio" name="class"
						id="exampleRadios1" value="economy" checked> <label
						class="form-check-label" for="exampleRadios1"
						style="padding-bottom: 10px"> Economy </label> <br> <input
						class="form-check-input" type="radio" name="class"
						id="exampleRadios2" value="premium"> <label
						class="form-check-label" for="exampleRadios1"
						style="padding-bottom: 10px"> Premium Economy </label> <br> <input
						class="form-check-input" type="radio" name="class"
						id="exampleRadios3" value="business"> <label
						class="form-check-label" for="exampleRadios1"> Business </label>
				</div>

			</div>

			<button class="btn btn-primary" type="submit" style="margin-left: 35%;" onclick="return searchFlight()">
				Search Flight
			</button>
		</form>
	</div>


	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	<!-- Datepicker Js -->
	<script src="static/js/wbn-datepicker.min.js"></script>

	<script type="text/javascript" src="js/searchFlight.js"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


	<script>
	<!-- Date Picker -->
		var date = $('#departure').datepicker({
			dateFormat : 'yy-mm-dd',
			minDate : new Date(),
			maxDate : "+1M"
		}).val();

		$(document).ready(function() {

			$('#departure').datepicker({
				yearRange : '1950:2019',

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