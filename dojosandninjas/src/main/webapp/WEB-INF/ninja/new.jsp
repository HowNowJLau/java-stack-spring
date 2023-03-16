<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body>
	<div class="container">
		<h1>New Ninja</h1>
		<form:form action="/ninjas/process" method="post" modelAttribute="newNinja">
		<div class="form-group">
			<label>Dojo:</label>
			<form:select path="dojo" class="form-control">
				<c:forEach var="dojo" items="${allDojos}">
					<form:option value="${dojo.id}">
						<c:out value="${dojo.name}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
			<label>First Name:</label>
			<form:input type="text" path="firstName" class="form-control"/>
			<form:errors path="firstName" class="text-danger"/>
		</div>
		<div class="form-group">
			<label>Last Name:</label>
			<form:input type="text" path="lastName" class="form-control"/>
			<form:errors path="lastName" class="text-danger"/>
		</div>
		<div class="form-group">
			<label>Age:</label>
			<form:input type="number" min="0" path="age" class="form-control"/>
			<form:errors path="age" class="text-danger"/>
		</div>
		<input type="submit" value="Create" class="btn btn-primary"/>
		</form:form>
	</div>
	
</body>
</html>