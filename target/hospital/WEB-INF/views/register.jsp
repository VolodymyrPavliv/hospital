<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link href="resources/css/common.css" rel="stylesheet" type="text/css"/>
    <link href="resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body class="body-blue">
    <h1 class="text-xl-center">Registration</h1>
    <form action="/register" method="post" class="form-signin">
        <div class="form-group">
            <label for="name"><strong>Name: </strong></label>
            <input type="text" id = "name" name="name" class="form-control" placeholder="Enter name"/><br>

            <label for="surname"><strong>Surname: </strong></label>
            <input type="text" id="surname" name="surname" class="form-control" placeholder="Enter surname"/><br>

            <label for="birthday"><strong>Date of birth: </strong></label>
            <input type="date" id="birthday" name="birthday" class="form-control"/><br>

            <label for="email"><strong>Email: </strong></label>
            <input type="email" id="email" name="email" class="form-control" placeholder="Enter email"/><br>

            <label for="password"><strong>Password: </strong></label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Enter password"/><br>

            <label for="confirm_password"><strong>Confirm Password: </strong></label>
            <input type="password" id="confirm_password" name="confirm-password" class="form-control" placeholder="Confirm password"/>

            <button class="btn btn-lg btn-danger btn-block" type="submit">Register</button>
            <h4 class="text-center"><a href="/login">Login</a></h4>
        </div>
    </form>
</body>
</html>
