<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
				<h1>Expense Details</h1>
			</div>
			<div class="column col-4">
				<a href="/expenses">Go Back</a>
			</div>
		</div>
		<div class="row">
			<div class="column col-4">
				<p>Expense Name:</p>
			</div>
			<div class="column col-4">
				<c:out value="${expense.name}"/>
			</div>
		</div>
		<div class="row">
			<div class="column col-4">
				<p>Expense Description:</p>
			</div>
			<div class="column col-4">
				<c:out value="${expense.description}"/>
			</div>
		</div>
		<div class="row">
			<div class="column col-4">
				<p>Vendor:</p>
			</div>
			<div class="column col-4">
				<c:out value="${expense.vendor}"/>
			</div>
		</div>
		<div class="row">
			<div class="column col-4">
				<p>Amount Spent:</p>
			</div>
			<div class="column col-4">
				<fmt:formatNumber value="${expense.amount}" type="currency"/>
			</div>
		</div>
	</div>
</body>
</html>