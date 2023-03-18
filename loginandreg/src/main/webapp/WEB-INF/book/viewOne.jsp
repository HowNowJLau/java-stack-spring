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
		<div class="d-flex flex-row align-items-end justify-content-between p-2 mb-10">
			<h1 class="fst-italic"><c:out value="${book.title}"/></h1>
			<a href="/home">back to the shelves</a>
		</div>
		<h3>
			<c:choose>
				<c:when test="${book.poster.id == user_id}">
					<p>You read <span style="color:rebeccapurple"><c:out value="${book.title}"/></span> by 
					<span style="color:green"><c:out value="${book.author}"/></span></p>
					<p>Here are your thoughts:</p>
				</c:when>
				<c:otherwise>
					<p><span style="color:red"><c:out value="${book.poster.userName}"/></span> read
					<span style="color:rebeccapurple"><c:out value="${book.title}"/></span> by 
					<span style="color:green"><c:out value="${book.author}"/></span></p>
					<p>Here are <c:out value="${book.poster.userName}"/>'s thoughts:</p>
				</c:otherwise>
			</c:choose>
		</h3>
		<div class="col-8 fst-italic ps-4">
			<hr>
			<c:out value="${book.thoughts}"/>
			<hr>
			<c:if test="${book.poster.id == user_id}">
				<form action="/books/${book.id}/delete" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" class="btn btn-danger float-end fst-normal" value="Delete"/>
				</form>
				<a href="/books/${book.id}/edit" class="btn btn-warning me-4 float-end fst-normal">Edit</a>
			</c:if>
		</div>
	</div>
</body>
</html>