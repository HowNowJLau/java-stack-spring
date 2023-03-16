<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Dojos and Ninjas</title>
</head>
<body>
	<div class="container">
		<h1>New Dojo</h1>
		<form:form action="/dojos/process" method="post" modelAttribute="newDojo">
			<div class="form-group">
				<label>Name:</label>
				<form:input type="text" path="name" class="form-control"/>
				<form:errors path="name" class="text-danger"/>
			</div>
			<input type="submit" value="Create" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>