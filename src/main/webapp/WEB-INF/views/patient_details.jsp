<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient Details</title>
</head>
<body>
    <p>${user.getName()} ${user.getSurname()}</p>
    <p><strong>Birthday: </strong>${user.getBirthday()}</p>
    <p><strong>Email: </strong>${user.getEmail()}</p>
    <p><strong>Doctor: </strong>${doctor.getName()} ${doctor.getSurname()}</p>
</body>
</html>
