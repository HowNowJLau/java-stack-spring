<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>You have visited your_server ${count} times</h2>
	<a href="/your_server">Test another visit?</a>
	<form action="/your_server/counter/reset">
		<input type="submit" value="Reset Counter"/>
	</form>
</body>
</html>