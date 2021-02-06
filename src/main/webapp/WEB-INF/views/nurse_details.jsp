<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nurse Details</title>
</head>
<body>
    <p>${nurse.getName()} ${nurse.getSurname()}</p>
    <p><strong>Birthday: </strong>${nurse.getBirthday()}</p>
    <p><strong>Email: </strong>${nurse.getEmail()}</p>
    <h4>Patients: </h4>
    <c:forEach items="${patients}" var="patient">
        <p><strong>Name: </strong>${patient.getName()} ${patient.getSurname()}</p>
    </c:forEach>
</body>
</html>
