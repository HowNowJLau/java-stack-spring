<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<form:form action="/donations/process/${donation.id}" method="post" modelAttribute="donation">
	<input type="hidden" name="_method" value="put"/>
		<div class="form-group">
			<form:label path="donationName">Donation Name</form:label>
			<form:input type="text" path="donationName" class="form-control"/>
			<form:errors class="text-danger" path="donationName"/>
		</div>
		<div class="form-group">
			<label>Quantity</label>
			<form:input type="number" path="quantity" class="form-control"/>
			<form:errors path="quantity"/>
		</div>
		<div class="form-group">
			<label>Donor</label>
			<form:input type="text" path="donor" class="form-control"/>
			<form:errors path="donor"/>
		</div>
		<input type="submit" value="Edit Donation" class="btn btn-primary"/>
	</form:form>
</body>
</html>