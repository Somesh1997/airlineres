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
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	type="text/css">

</head>

<body
	style="font-family: Alata; background-image: url('images/UpcomingJourneys.jpg'); background-size: cover; background-repeat: no-repeat; background-attachment: fixed;">
	<!-- Session template -->
	<%
		if (session.getAttribute("uname") != null && (int) session.getAttribute("isAdmin") == 2) {
	%>

	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: white;"
				href="AdminDashboard.jsp"> <img src="images/Flight.png"
					width="40" height="40"> SAVAN Airlines
			</a>
			</span>
		</div>

	</div>

	<a class="pr-4" href="AdminDashboard.jsp" style="float: right">
		<button type="button" class="btn btn-outline-primary">
			<i class="fa fa-chevron-circle-left" aria-hidden="true"></i> Back
		</button>
	</a>

	<br>
	<br>
	<br>




	<div class="container">
		<h1 style="color: #0af5e5">All the Flight Details are:</h1>

		<br>

		<h4 style="color: #9BE0F7">Have a safe and happy journey.</h4>

		<div class="pr-5 mr-5">
			<a href="AddFlights.jsp"><button type="button" onclick=""
					class="btn btn-primary" style="float: right;">Add</button></a>
		</div>

		<table id="example" class="table table-striped table-borderless ">
			<thead>
				<tr style="color: #0c96c4">
					<th>Route Id</th>
					<th>Flight No</th>
					<th>Capacity</th>
					<th>Source</th>
					<th>Departure</th>
					<th>Destination</th>
					<th>Arrival</th>
					<th>Duration</th>
					<th>Cost</th>
					<th colspan="2">Flight Operations</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="details" items="${flightlist}">
					<tr>
						<td><c:out value="${details.routeId}"></c:out></td>
						<td><c:out value="${details.flightno}"></c:out></td>
						<td><c:out value="${details.capacity}"></c:out></td>
						<td><c:out value="${details.source}"></c:out></td>
						<td><c:out value="${details.departure}"></c:out></td>
						<td><c:out value="${details.destination}"></c:out></td>
						<td><c:out value="${details.arrival}"></c:out></td>
						<td><c:out value="${details.duration}"></c:out></td>
						<td><c:out value="${details.cost}"></c:out></td>
						<form method="post" action="FlightActionController">
							<input type="hidden" value="${details.flightno }" name="flightno">
							<td><button type="submit" name="frs" value="modify"
									class="btn btn-sm btn-warning">Modify</button></td>
							<td><button type="submit" name="frs" value="delete"
									class="btn btn-sm btn-danger" onclick="return confirmDelete()">Delete</button></td>
						</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>

	<!-- Mandatory Files START -->
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
	<!-- Mandatory Files END -->

	<script type="text/javascript">
		function confirmDelete() {
			var a = window
					.confirm("Are you sure you really want to cancel this flight?");
			return a;
		}
	</script>

	<!-- Session template -->
	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>
</body>
</html>