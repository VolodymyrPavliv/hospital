<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
    <c:if test="${not_registered_yet != null}">
        <p>You are not registered yet.</p>
        <p>Please try logging in later.</p>
    </c:if>
    <label for="email">Email: </label><br>
    <input type="email" id="email" name="email"/><br>

    <label for="password">Password: </label><br>
    <input type="password" id="password" name="password"/><br><br>

    <input type="submit" value="Login"/>
    <h4 class="text-center"><a href="/register">Create an account</a></h4>
</form>
</body>
</html>
