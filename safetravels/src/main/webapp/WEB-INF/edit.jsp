<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Safe Travels</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="column col-8">
				<h1>Edit Expense</h1>
			</div>
			<div class="column col-4">
				<a href="/expenses">Go Back</a>
			</div>
		</div>
		<form:form action="/expenses/edit/${expense.id}/process" method="post" modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			<div class="form-group">
				<label>Expense Name:</label>
				<form:input type="text" path="name" class="form-control"/>
				<form:errors class="text-danger" path="name"/>
			</div>
			<div class="form-group">
				<label>Vendor:</label>
				<form:input type="text" path="vendor" class="form-control"/>
				<form:errors class="text-danger" path="vendor"/>
			</div>
			<div class="form-group">
				<label>Amount:</label>
				<form:input type="text" path="amount" class="form-control"/>
				<form:errors class="text-danger" path="amount"/>
			</div>
			<div class="form-group">
				<label>Description:</label>
				<form:input type="text" path="description" class="form-control"/>
				<form:errors class="text-danger" path="description"/>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>