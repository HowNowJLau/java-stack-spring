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
	<h1>Create a new donation</h1>
	<form:form action="/donations/process/new" method="post" modelAttribute="newDonation">
	<div class="form-group">
		<label>Donation Name</label>
		<form:input path="donationName" class="form-control"/>
		<form:errors path="donationName" class="text-danger"/>
	</div>
	<div class="form-group">
		<label>Quantity</label>
		<form:input path="quantity" class="form-control"/>
		<form:errors path="quantity" class="text-danger"/>
	</div>
	<div class="form-group">
		<label>Donor</label>
		<form:select path="donor" class="form-control">
			<c:forEach var="user" items="${allUsers}">
				<form:option value="${user.id}" path="donor">
					<c:out value="${user.userName}"/>
				</form:option>
			</c:forEach>
		</form:select>
		<form:errors path="donor" class="text-danger"/>
	</div>
	<input type="submit" value="Add Donation" class="btn btn-primary">
	</form:form>
</body>
</html>