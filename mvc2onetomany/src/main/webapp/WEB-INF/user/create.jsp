<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Insert title here</title>
</head>
<body>
	<h1>Create a new user</h1>
	<form:form action="/user/process/new" method="post" modelAttribute="newUser">
	<div class="form-group">
		<label>UserName</label>
		<form:input path="userName" class="form-control"/>
		<form:errors path="userName" class="text-danger"/>
	</div>
	<div class="form-group">
		<label>Email</label>
		<form:input path="email" class="form-control"/>
		<form:errors path="email" class="text-danger"/>
	</div>
	<input type="submit" value="Add User" class="btn btn-primary">
	</form:form>
</body>
</html>