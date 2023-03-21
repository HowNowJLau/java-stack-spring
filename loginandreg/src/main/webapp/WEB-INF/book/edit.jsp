<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Book Share</title>
</head>
<body>
	<div class="container">
		<div class="d-flex flex-row align-items-end justify-content-between p-2">
			<h1>Change your Entry</h1>
			<a href="/home">back to the shelves</a>
		</div>
		<form:form action="/books/${book.id}/process" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put"/>
			<form:hidden path="poster"/>
			<div class="col-6 offset-2">
				<p><form:errors path="title" class="text-danger"/></p>
				<p><form:errors path="author" class="text-danger"/></p>
				<p><form:errors path="thoughts" class="text-danger"/></p>
			</div>
			<div class="row align-items-center mb-4">
				<div class="col-2">
					<label class="col-form-label">Title</label>
				</div>
				<div class="col-6">
					<form:input path="title" class="form-control" value="${book.title}"/>
				</div>
			</div>
			<div class="row align-items-center mb-4">
				<div class="col-2">
					<label class="col-form-label">Author</label>
				</div>
				<div class="col-6">
					<form:input path="author" class="form-control" value="${book.author}"/>
				</div>
			</div>
			<div class="row g-3 align-items-start mb-4">
				<div class="col-2">
					<label class="col-form-label">My Thoughts</label>
				</div>
				<div class="col-6">
					<form:textarea path="thoughts" class="form-control" cols="200" value="${book.thoughts}"/>	
				</div>
			</div>
			<div class="col-6 offset-2">
				<input type="submit" class="btn btn-primary float-end"/>
			</div>
		</form:form>
	</div>
</body>
</html>