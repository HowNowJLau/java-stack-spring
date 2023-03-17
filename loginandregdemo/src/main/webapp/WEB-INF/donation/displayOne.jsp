<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
	<h1>Show One Donation</h1>
	<h2>Donation Name: <c:out value="${donation.donationName}"/></h2>
	<p>Quantity: ${donation.quantity}</p>
	<h3>Donor: <c:out value="${donation.donor.userName}"/></h3>
	<form action="/donations/${donation.id}/delete" method="post">
		<input type="hidden" name="_method" value="delete"/>
		<input type="submit" value="Delete" class="btn btn-danger"/>
	</form>
</body>
</html>