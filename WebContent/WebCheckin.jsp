<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Web Check-in</title>

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
<body style="background-color:powderblue;">

<br><br><br>
	<c:set var="can" scope="request" value="${ ress }" />
	<c:if test="${ requestScope.can != null }">
		<div class="container">
			<div class="alert alert-danger alert-dismissible fade show col-md-8"
				role="alert">
				<strong style="padding-right: 10px;"">Error! PNR not found </strong> Please enter correct pnr
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
		</div>
	</c:if>
	<form action="GeneratePDF" method="get">
		<table style="padding-top:50px;" align="center">
		<tr><th>Enter your PNR number</th><th></th></tr>
		<tr><td rowspan="2"><input type="text" name="pnr" autofocus maxlength="10"></td></tr>
		<tr><td></td><td><input type="submit"></td></tr>
		</table>
	</form>
	
	
	
	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

	<!-- jQuery UI -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>


	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>