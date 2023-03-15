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
		<h1>Safe Travels</h1>
		<table class="table text-center">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expense" items="${allExpenses}">
					<tr>
						<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
						<td><c:out value="${expense.vendor}"/></td>
						<td><fmt:formatNumber value="${expense.amount}" type="currency"/></td>
						<td><a href="/expenses/edit/${expense.id}">Edit</a></td>
						<td>
							<form action="/expenses/delete/${expense.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="Delete" class="btn btn-danger">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h1>Add an expense:</h1>
		<form:form action="/expenses/process" method="post" modelAttribute="expense">
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