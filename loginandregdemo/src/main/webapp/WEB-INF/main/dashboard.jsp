<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome <c:out value="${loggedUser.userName}"/></h1>
	<a href="/users/logout" class="btn btn-outline-danger">Log Out</a>
	<a href="/donations/create" class="btn btn-outline-primary">Create Donation</a>
	<table class="table">
		<thead>
			<tr>
				<th>Donation Name</th>
				<th>Quantity</th>
				<th>Donor</th>
				<th>Action</th>
			</tr>
			<tbody>
				<c:forEach var="donation" items="${allDonations}">
					<tr>
						<td><a href="/donations/${donation.id}">${donation.donationName}</a></td>
						<td>${donation.quantity}</td>
						<td>${donation.donor.userName}</td>
						<td class="d-flex"><a href="/donations/${donation.id}/edit" class="btn btn-warning">Edit</a>
							<form:form action="/donations/${donation.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<input type="submit" value="Delete" class="btn btn-danger"/>
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>