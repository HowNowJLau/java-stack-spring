<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Product Page</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center mb-10"><c:out value="${product.productName}"/></h1>
		<a href="/">Home</a>
		<hr>
		<h2>Categories:</h2>
		<ul>
			<c:forEach var="category" items="${product.categories}">
				<li><c:out value="${category.categoryName}"/></li>
			</c:forEach>
		</ul>
		<hr>
		<form action="/products/${product.id}/addCategory" method="post">
			<label class="form-label">Add Category:</label>
			<select class="form-control" name="categoryToAdd">
				<c:forEach var="category" items="${addCategories}">
					<option value="${category.id}"><c:out value="${category.categoryName}"/></option>
				</c:forEach>
			</select>
			<input type="submit" value="Add" class="btn btn-primary">
		</form>
	</div>
</body>
</html>