<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome, <c:out value="${loggedUser.userName}"/>!</h1>
	<p>This is your dashboard. Nothing to see here yet</p>
	<a href="/logout">logout</a>
</body>
</html>