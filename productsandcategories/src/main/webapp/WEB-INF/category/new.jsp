<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>New Category</title>
</head>
<body>
	<div class="container">
		<h1 class="text-center mb-20">New Category</h1>
		<a href="/">Home</a>
		<hr>
		<form:form action="/categories/new/process" method="post" modelAttribute="category">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td>
						<form:input path="categoryName" class="form-control"/>
						<form:errors path="categoryName" class="text-danger"/>
						</td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit" class="btn btn-primary"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
	</div>
</body>
</html>