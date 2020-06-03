<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css"
	type="text/css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	type="text/css">
</head>
<body
	style="background-image: url('https://images.unsplash.com/photo-1518655048521-f130df041f66?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=750&amp;q=80'); background-size: cover; background-repeat: no-repeat; background-attachment: fixed; background-position: center; height: 100%; opacity: 1.0;">
	<!-- Session template -->
	<%
		if (session.getAttribute("uname") != null && (int) session.getAttribute("isAdmin") == 2) {
	%>
	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: #18bbe0;"
				href="AdminDashboard.jsp"> <img src="images/Flight.png"
					width="40" height="40"> SAVAN Airlines
			</a>
			</span> <a class="pr-4" href="AdminDashboard.jsp" style="float: right">
				<button type="button" class="btn btn-danger">
					<i class="fa fa-chevron-circle-left" aria-hidden="true"></i> Back
				</button>
			</a>
		</div>
	</div>

	<br>
	<br>
	<div class="container">
		<table id="example" class="table table-striped table-borderless ">
			<thead>
				<tr>
					<th>Passenger Name</th>
					<th>Age</th>
					<th>Seat No</th>
					<th>Booking Date</th>
					<th>Airline No</th>
					<th>Departure Time</th>
					<th>Arrival Time</th>
					<th>Booked By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fdetails" items="${details }">
					<tr>
						<td><c:out value="${fdetails.passenger }"></c:out></td>
						<td><c:out value="${fdetails.age }"></c:out></td>
						<td><c:out value="${fdetails.seatno }"></c:out></td>
						<td><c:out value="${fdetails.bookingDate }"></c:out></td>
						<td><c:out value="${fdetails.flightNo }"></c:out></td>
						<td><c:out value="${fdetails.departure }"></c:out></td>
						<td><c:out value="${fdetails.arrival }"></c:out></td>
						<td><c:out value="${fdetails.username }"></c:out></td>
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
	<!-- Session template -->
	<%
		} else {
			response.sendRedirect("Login.jsp");
		}
	%>
</body>
</html>