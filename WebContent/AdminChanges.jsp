<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<style>
.w3-black, .w3-hover-black:hover {
	color: white !important;
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
<link rel="stylesheet" href="/css/wbn-datepicker.css">

</head>

<body
	style="font-family: Alata; background-image: url('images/SignUpBackground.jpg'); background-size: cover; background-repeat: no-repeat; background-attachment: fixed;">

	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: white;"
				href="AdminDashboard.jsp"> <img src="images/Flight.png" width="40"
					height="40"> SAVAN Airlines
			</a>
			</span>
		</div>
	</div>
	
	<a class="pr-4" href="AdminDashboard.jsp" style="float: right">
		<button type="button" class="btn btn-outline-light">
			<i class="fa fa-chevron-circle-left" aria-hidden="true"></i> Back
		</button>
	</a>

	<br>
	<br>


	<div class="col-md-10"
		style="border: 1px solid white; margin: auto; width: 35%; border-radius: 10px; background-color: white; padding: 20px;">
		<form action="AdminChangesController" method="POST">
		<input type="hidden" value="${flightmodify.flightno }" name="flightName">
			<h3 style="text-align: center; color: dodgerblue">Flight Modifications</h3>

			<br>

			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="flightNo">Flight No</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="flightNo"
						name="flightNo" value="${flightmodify.flightno }" disabled placeholder="Flight No" autofocus required>
				</div>
				<div class="form-group col-md-6">
					<label for="routeID">Route ID</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="routeID"
						name="routeID" value="${flightmodify.routeId }" placeholder="routeID" disabled required>
				</div>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="capacity">Capacity</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="capacity"
						name="capacity" value="${flightmodify.capacity }" placeholder="Capacity" required>
				</div>
				<div class="form-group col-md-6">
					<label for="costDetails">Cost Details</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="costDetails"
						name="costDetails" value="${flightmodify.cost }" placeholder="Cost Details" required>
				</div>
			</div>	
				
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="source">Source</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="source"
						name="source" value="${flightmodify.source }" placeholder="Source" disabled required>
				</div>
				<div class="form-group col-md-6">
					<label for="destination">Destination</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="destination"
						name="destination" value="${flightmodify.destination }" placeholder="Destination" disabled required>
				</div>
			</div>
			
			<div class="form-row">
				<div class="form-group col-md-4">
					<label for="departure">Departure Time</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="departure"
						name="departure" value="${flightmodify.departure }" placeholder="Departure" required>
				</div>
				<div class="form-group col-md-4">
					<label for="arrival">Arrival Time</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="arrival"
						name="arrival" value="${flightmodify.arrival }" placeholder="Arrival" required>
				</div>
				<div class="form-group col-md-4">
					<label for="duration">Duration</label> <input type="text"
						maxlength="20" min="2" class="form-control" id="duration"
						name="duration" value="${flightmodify.duration }" placeholder="Duration" required>
				</div>
			</div>

			<div class="form-group" style="text-align: center; margin-bottom: 0;">
				<button class="btn btn-primary" style="text-decoration: none;" role="button">Modify</button>
			</div>
		</form>
	</div>


	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	<!-- Datepicker Js -->
	<script src="/js/wbn-datepicker.min.js"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

	<script>

		var date = $('#dob').datepicker({
			changeMonth: true,
            changeYear: true,
			dateFormat : 'yy/mm/dd'
			
		}).val();

		$(document).ready(function() {

			$('#dob').datepicker({
				
				yearRange : "1950:2019",
			});

		});
	</script>
	<script type="text/javascript" src="js/validate.js"></script>
</body>
</html>