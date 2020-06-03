<%@ page session="true" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Flights</title>

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
	style="font-family: Alata; background-image: url('images/BookFlights.jpg'); background-size: cover; background-repeat: no-repeat; background-attachment: fixed; background-position: center; height: 100%">

	<!-- Session template -->
	<%
		if (session.getAttribute("uname") != null && (int) session.getAttribute("isAdmin") == 1) {
	%>


	<input type="hidden" value="${passengers }" name="passenger"
		id="passenger">
	<div class="w3-bar w3-block" style="padding: 10px">
		<div class="w3-bar-item-left">
			<span style="font-size: 40px;"> <a
				style="text-decoration: none; padding-left: 15px; color: white;"
				href="CustomerDashboard.jsp"> <img src="images/Flight.png"
					width="40" height="40"> SAVAN Airlines</a>
			</span> 
			<a class="pr-4" href="CustomerDashboard.jsp" style="float: right">
				<button type="button" class="btn btn-outline-primary">
					<i class="fa fa-chevron-circle-left" aria-hidden="true"></i> Back
				</button>
			</a>
		</div>
	</div>

	<br>

	<div class="container">

		<h1 style="color: #217aed">Enter Passenger Details...</h1>

		<br>
		<form action="PaymentProcessController" method="post">
			<input type="hidden" value="${date }" name="date"> <input
				type="hidden" value="${passengers }" name="passengers"> <input
				type="hidden" value="${category }" name="category"> <input
				type="hidden" value="${flight }" name="flightno">
			<table class="table table-borderless col-md-8">
				<tbody id="dynamic_field">

				</tbody>
			</table>
			<br>
			<div class="mb-4" align="center">
				<button class="btn btn-primary" type="submit"
					onclick="return checkPassengerDetails();">
					Pay &#8377;
					<c:out value="${fare }"></c:out>
				</button>
			</div>
		</form>

	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


	<script type="text/javascript">
		var p = document.getElementById('passenger').value;
		for (var i = 1; i <= p; i++) {
			$('#dynamic_field')
					.append(
							'<tr style="color: white"><td colspan="2" style="padding-top:45px;"><h4> Add Passenger '
									+ i
									+ ' Details </h4></td><td style="color: #00fad9"><label for="name">First Name</label><input type="text" class="form-control" size="10" style="float: left" maxlength="20" min="2" id="firstName'+i+'" name="firstName'+i+'" placeholder="Enter your name" required></td><td style="color: #00fad9"><label for="age">Age</label><input type="text" class="form-control" size="3" style="float: left" maxlength="20" min="2" id="age'+i+'" name="age'+i+'" placeholder="Age"  required></td></tr>');
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