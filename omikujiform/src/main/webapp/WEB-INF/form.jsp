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
	<div class="container">
		<h1>Send an Omikuji!</h1>
		<form action="/omikuji/submit" method="POST">
			<div class="mb-3">
				<label class="form-label">Pick any number from 5 to 25</label>
				<input type="number" name="number" class="form-control" min="5" max="25" value="5"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Enter the name of any city</label>
				<input type="text" name="city" class="form-control"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Enter the name of any real person</label>
				<input type="text" name="name" class="form-control"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Enter professional endeavor or hobby</label>
				<input type="text" name="endeavor" class="form-control"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Enter any type of living thing</label>
				<input type="text" name="livingThing" class="form-control"/>
			</div>
			<div class="mb-3">
				<label class="form-label">Say something nice to someone</label>
				<input type="text" name="niceMessage" class="form-control"/>
			</div>
			<input type="submit" value="Submit" class="btn btn-primary"/>
		</form>
	</div>
</body>
</html>