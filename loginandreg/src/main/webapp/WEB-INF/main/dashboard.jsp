<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Read Share</title>
</head>
<body>
	<div class="container">
		<div class="d-flex flex-row align-items-end justify-content-between p-2">
			<h1>Welcome, <c:out value="${loggedUser.userName}"/>!</h1>
			<a href="/logout">logout</a>
		</div>
		<div class="d-flex flex-row align-items-center justify-content-between p-2">
			Books from everyone's shelves:
			<a href="/books/create">+ Add a book to my shelf!</a>
		</div>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="book" items="${allBooks}">
					<tr>
						<td>${book.id}</td>
						<td><a href="/books/${book.id}/view"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.poster.userName}"/></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>