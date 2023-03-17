<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<meta charset="ISO-8859-1">
<title>Login Registration</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>Register</h1>
                <form:form action="/users/process/register" method="post" modelAttribute="newUser">
                    <div class="form-group">
                        <label>User Name</label>
                        <form:input path="userName" class="form-control" />
                        <form:errors path="userName" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <form:input path="email" class="form-control" />
                        <form:errors path="email" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <form:input path="password" class="form-control" />
                        <form:errors path="password" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Confirm Password</label>
                        <form:input path="confirm" class="form-control" />
                        <form:errors path="confirm" class="text-danger" />
                    </div>
                    <input type="submit" value="Register User" class="btn btn-primary" />
                </form:form>
            </div>
            <div class="col">
            <h1>Login</h1>
            <form:form action="/users/login" method="post" modelAttribute="loginUser">
                    <div class="form-group">
                        <label>Email</label>
                        <form:input path="email" class="form-control" />
                        <form:errors path="email" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <form:input path="password" class="form-control" />
                        <form:errors path="password" class="text-danger" />
                    </div>
                    <input type="submit" value="Login" class="btn btn-primary" />
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>