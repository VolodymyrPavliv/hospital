<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="/register" method="post">
        <label for="name">Name: </label><br>
        <input type="text" id = "name" name="name"/><br>

        <label for="surname">Surname: </label><br>
        <input type="text" id="surname" name="surname"/><br>

        <label for="email">Email: </label><br>
        <input type="email" id="email" name="email"/><br>

        <label for="password">Password: </label><br>
        <input type="password" id="password" name="password"/><br>

        <label for="confirm_password">Confirm Password: </label><br>
        <input type="password" id="confirm_password" name="confirm-password"/><br><br>

        <input type="submit" value="Create Account"/>
    </form>
</body>
</html>
