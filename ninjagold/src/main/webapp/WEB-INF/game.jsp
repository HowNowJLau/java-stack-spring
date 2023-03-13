<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Ninja Gold Game</title>
</head>
<body>
	<div class="container">
		<h3 class="mb-3">Your Gold: <c:out value="${gold}"/></h3>
		<div class="d-flex justify-content-between">
			<form action="/find/gold" method="POST" class="p-4 border border-dark border-2 text-center">
				<h3>Farm</h3>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="location" value="farm"/>
				<input type="submit" value="Find Gold!"/>
			</form>
			<form action="/find/gold" method="POST" class="p-4 border border-dark border-2 text-center">
				<h3>Cave</h3>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="location" value="cave"/>
				<input type="submit" value="Find Gold!"/>
			</form>
			<form action="/find/gold" method="POST" class="p-4 border border-dark border-2 text-center">
				<h3>House</h3>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="location" value="house"/>
				<input type="submit" value="Find Gold!"/>
			</form>
			<form action="/find/gold" method="POST" class="p-4 border border-dark border-2 text-center">
				<h3>Quest</h3>
				<p>(earns/takes 0-50 gold)</p>
				<input type="hidden" name="location" value="quest"/>
				<input type="submit" value="Find Gold!"/>
			</form>
		</div>
		
		<h3 class="mb-3">Activities:</h3>
		<div class="container border border-dark border-2 overflow-auto" style="height:200px">
			<c:forEach var="activity" items="${activities}">
				${activity}
			</c:forEach>
		</div>
	</div>
</body>
</html>