<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/css/style.css"> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Demo</title>
</head>
<body>
	<h1>JSTL Demo</h1>
	<h1 class="styleTest">Style Testing</h1>
	<h1>Displaying Variables</h1>
	<p><c:out value="${name}"/></p>
	<p>${age}</p>
	<p>${isMillionaire}</p>
	<h1><c:out value="${test}"/></h1>
	<h1>if-statement</h1>
	<c:if test="${isMillionaire}">
		<p><c:out value="${name}"/> is a millionaire.</p>
	</c:if>
	
	<h1>if-else statement</h1>
	<c:choose>
		<c:when test="${age > 21}">
			<p>Cannot buy drinks yet</p>
		</c:when>
		<c:otherwise>
			<p>Can buy drinks</p>
		</c:otherwise>
	</c:choose>
	
	<h1>for each</h1>
	<ul>
		<c:forEach var="eachUser" items="${users}">
			<li><c:out value="${eachUser}"/></li>
		</c:forEach>
	</ul>
	
</body>
</html>