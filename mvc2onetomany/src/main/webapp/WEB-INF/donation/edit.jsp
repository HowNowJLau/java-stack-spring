<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
	<h1>Edit donation</h1>
	<form:form action="/donations/{id}/process" method="post" modelAttribute="donation">
	<input type="hidden" name="_method" value="put"/>
	<form:hidden path="donor"/>
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
	<input type="submit" value="Add Donation" class="btn btn-primary">
	</form:form>
</body>
</html>