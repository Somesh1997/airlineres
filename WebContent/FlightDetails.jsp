<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

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

<title>Flight Details</title>

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
	style="font-family: Alata; background-image: url('images/FlightDetails.jpg'); background-size: cover; 
	background-repeat: no-repeat; background-attachment: fixed;  background-position: center; height: 100%">

	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: white;"
				href="CustomerDashboard.jsp"> <img src="images/Flight.png" width="40"
					height="40"> SAVAN Airlines
			</a>
			</span>
		</div>

	</div>
	
	<a class="pr-4" href="CustomerDashboard.jsp" style="float: right">
		<button type="button" class="btn btn-outline-primary">
			<i class="fa fa-chevron-circle-left" aria-hidden="true"></i> Back
		</button>
	</a>

	<br>
	<br>
	<br>

	<div class="container">
	
		<h1 style="color: #0af5e5">Here are all the Flights on <c:out value="${date }"></c:out></h1>
		
		<br>
		<h4 style="color: #0d9dd6">Book with any of the given flight</h4>
		
		<br>
		
		<table class="table table-hover table-borderless table-responsive">
			<thead>
				<tr style="color: #0d9dd6">
					<th scope="col">Flight Number</th>
					<th scope="col">Flight Name</th>
					<th scope="col">Source</th>
					<th scope="col">Departure Time</th>
					<th scope="col">Destination</th>
					<th scope="col">Arrival Time</th>
					<th scope="col">Duration</th>
					<th scope="col">Cost</th>
					<th scope="col">Book Now</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="details" items="${flightsInfo }">
				<tr>	
					<td><c:out value="${details.flightNo }"></c:out></td>
					<td><c:out value="${details.flightName }"></c:out></td>
					<td><c:out value="${details.source }"></c:out></td>
					<td><c:out value="${details.departureTime }"></c:out></td>
					<td><c:out value="${details.destination }"></c:out></td>
					<td><c:out value="${details.arrivalTime }"></c:out></td>
					<td><c:out value="${details.duration }"></c:out></td>
					<td><c:out value="${details.cost }"></c:out></td>
					<form action="BookFlightController" method="post">
					<input type="hidden" value="${date }" name="date">
					<input type="hidden" value="${passengers }" name="passengers">
					<input type="hidden" value="${category }" name="category">
					<input type="hidden" value="${details.flightNo }" name="flightno">
					<td><button type="submit" class="btn btn-info btn-sm">Book Now</button>
					</td>
					</form>	
				</tr>
			</c:forEach>
			</tbody>
		</table>


	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>