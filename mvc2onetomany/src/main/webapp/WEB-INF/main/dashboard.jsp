<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
	<h1>Dashboard</h1>
	<a href="/user/create">Create a new user</a>
	<a href="/donations/create">Create a new donation</a>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Donation Name</th>
				<th>Quantity</th>
				<th>Donor</th>
				<th>Action</th>
			</tr>
			<tbody>
				<c:forEach var="donation" items="${allDonations}">
					<tr>
						<td>${donation.id}</td>
						<td>${donation.donationName}</td>
						<td>${donation.quantity}</td>
						<td>${donation.donor.userName}</td>
						<td><a href="/donations/${donation.id}/edit" class="btn btn-warning">Edit</a>
							<form:form action="donations/${donation.id}/delete" method="post">
							<input type="hidden" name="_method" value="delete"/>
							<input type="submit" value="Delete" class="btn btn-danger"/>
							</form:form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
	<h1>All the Users</h1>
	<table class="table">
		<thead>
			<tr>
				<th>ID</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Number of Donations</th>
			</tr>
			<tbody>
				<c:forEach var="user" items="${allUsers}">
					<tr>
						<td>${user.id}</td>
						<td><a href="/user/${user.id}">${user.userName}</a></td>
						<td>${user.email}</td>
						<td>${user.donations.size()}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>