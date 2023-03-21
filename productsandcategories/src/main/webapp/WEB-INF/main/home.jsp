<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center mb-20">Home Page</h1>
		<a href="/products/new">New Product</a><br>
		<a href="/categories/new">New Category</a>
		<hr>
		<table class="table table-bordered">
			<thead>
				<tr class="text-center">
					<th>Products</th>
					<th>Categories</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<ul>
							<c:forEach var="product" items="${allProducts}">
								<li>
								<a href="/products/${product.id}"><c:out value="${product.productName}"/></a>
								</li>
							</c:forEach>
						</ul>
					</td>
					<td>
						<ul>
							<c:forEach var="category" items="${allCategories}">
								<li><a href="/categories/${category.id}"><c:out value="${category.categoryName}"/></a></li>
							</c:forEach>
						</ul>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>