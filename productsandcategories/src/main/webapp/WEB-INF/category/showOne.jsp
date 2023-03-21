<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Category Page</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center mb-10"><c:out value="${category.categoryName}"/></h1>
		<a href="/">Home</a>
		<hr>
		<h2>Products:</h2>
		<ul>
			<c:forEach var="product" items="${category.products}">
				<li><c:out value="${product.productName}"/></li>
			</c:forEach>
		</ul>
		<hr>
		<form action="/categories/${category.id}/addProduct" method="post">
			<label class="form-label">Add Product:</label>
			<select class="form-control" name="productToAdd">
				<c:forEach var="product" items="${addProducts}">
					<option value="${product.id}"><c:out value="${product.productName}"/></option>
				</c:forEach>
			</select>
			<input type="submit" value="Add" class="btn btn-primary">
		</form>
	</div>
</body>
</html>