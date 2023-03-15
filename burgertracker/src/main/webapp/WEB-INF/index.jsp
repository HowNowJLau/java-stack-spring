<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Burger Tracker</title>
</head>
<body>
	<div class="container">
		<h1>Burger Tracker</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>Burger Name</th>
					<th>Restaurant Name</th>
					<th>Rating (out of 5)</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="burger" items="${burgers}">
					<tr>
						<td><c:out value="${burger.name}"/></td>
						<td><c:out value="${burger.restaurant}"/></td>
						<td><c:out value="${burger.rating}"/></td>
						<td><a href="/${burger.id}/edit">Edit</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1>Add a Burger:</h1>
		<form:form action="/process" method="post" modelAttribute="burger">
			<div class="form-group">
				<label>Burger Name</label>
				<form:input type="text" path="name" class="form-control"/>
				<form:errors class="text-danger" path="name"/>
			</div>
			<div class="form-group">
				<label>Restaurant Name</label>
				<form:input type="text" path="restaurant" class="form-control"/>
				<form:errors class="text-danger" path="restaurant"/>
			</div>
			<div class="form-group">
				<label>Rating</label>
				<form:input type="number" min="0" max="5" value="0" path="rating" class="form-control"/>
				<form:errors class="text-danger" path="rating"/>
			</div>
			<div class="form-group">
				<label>Notes</label>
				<form:input type="text" path="notes" class="form-control"/>
				<form:errors class="text-danger" path="notes"/>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>