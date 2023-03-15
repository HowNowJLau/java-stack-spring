<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Burger Tracker</title>
</head>
<body>
	<div class="container">
		<h1>Edit Burger</h1>
		<form:form action="/${burger.id}/process" method="post" modelAttribute="burger">
		<input type="hidden" name="_method" value="put">
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
				<form:input type="number" min="0" max="5" path="rating" class="form-control"/>
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