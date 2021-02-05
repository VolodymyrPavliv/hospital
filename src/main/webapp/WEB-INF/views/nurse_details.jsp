<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nurse Details</title>
</head>
<body>
    <p>${user.getName()} ${user.getSurname()}</p>
    <p><strong>Birthday: </strong>${user.getBirthday()}</p>
    <p><strong>Email: </strong>${user.getEmail()}</p>
    <h4>Patients: </h4>
    <c:forEach items="${patients}" var="patient">
        <p><strong>Name: </strong>${patient.getName()} ${patient.getSurname()}</p>
    </c:forEach>
</body>
</html>
