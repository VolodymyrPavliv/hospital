<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <link href="resources/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body class="body-blue">
    <div class="container mt-5">
        <form action="/login" method="post" class="form-signin">
            <h1 class="form-heading">Login</h1>
            <div class="form-group">
                <c:if test="${not_registered_yet!=null}">
                <h3 class="text-left text-info">You're not registered yet.
                Please, try later.</h3>
                </c:if>
                <label for="email"><strong>Email:</strong> </label>
                <input id = "email" class="form-control" name="email" type="email" placeholder="Your email"/><br>
                <label for="password"><strong>Password: </strong></label>
                <input id = "password" class="form-control" name="password" type="password" placeholder="Your password" />
                <button class="btn btn-lg btn-danger btn-block" type="submit">Login</button>
                <h4 class="text-center"><a href="/register">Create an account</a></h4>
            </div>
        </form>
    </div>
</body>
</html>

