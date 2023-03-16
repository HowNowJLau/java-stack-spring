<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>User Details</h1>
	<h3>User Name: <c:out value="${user.userName }"/></h3>
	<h3>Email: <c:out value="${user.email }"/></h3>
	<h3>All <c:out value="${user.userName }"/>'s Donations:</h3>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Donation Name</th>
				<th>Quantity</th>
				<th>Donor</th>
			</tr>
			<tbody>
				<c:forEach var="donation" items="${user.donations}">
					<tr>
						<td>${donation.id}</td>
						<td>${donation.donationName}</td>
						<td>${donation.quantity}</td>
						<td>${donation.donor.userName}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>