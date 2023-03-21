<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
	<h1>Create a new game</h1>
	<form:form action="/games/process" method="post" modelAttribute="game">
	<div class="form-group">
		<label>Title</label>
		<form:input path="title" class="form-control"/>
		<form:errors path="title" class="text-danger"/>
	</div>
	<div class="form-group">
		<label>Genres</label>
		<form:input path="genresFromForm" class="form-control"/>
		<form:errors path="genresFromForm" class="text-danger"/>
	</div>
	<input type="submit" value="Add Game" class="btn btn-primary">
	</form:form>
	
	<table class="table table-dark">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Genres</th>
			</tr>
			<tbody>
				<c:forEach var="game" items="${allGames}">
					<tr>
						<td>${game.id}</td>
						<td>${game.title}</td>
						<td><c:forEach var="genre" items="${game.genres}">
							<c:out value="${genre.name}"/>
							</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>