<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Dojos and Ninjas</title>
</head>
<body>
	<h1>Dojos and Ninjas</h1>
	<a href="/dojos/new">Add a Dojo</a>
	<a href="/ninjas/new">Enroll a Ninja</a>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Number of Ninjas</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${allDojos}">
				<tr>
					<td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
					<td><c:out value="${dojo.ninjas.size()}"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>