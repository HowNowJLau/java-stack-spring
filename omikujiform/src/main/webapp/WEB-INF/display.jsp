<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Omikuji</title>
</head>
<body>
	<div class="container col-6">
		<h1>Here's your Omikuji!</h1>
		<div class="container bg-info border border-dark">
			<p class="fs-2">In ${number} years, you will live in ${city} with ${name} as your roommate,
			${endeavor} for a living. The next time you see a ${livingThing}, you will have
			good luck. Also, ${niceMessage}</p>
		</div>
		<a href="/omikuji">Go Back</a>
	</div>
</body>
</html>