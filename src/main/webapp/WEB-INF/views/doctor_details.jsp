<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Doctor Details</title>
</head>
<body>
    <p>${doctor.getName()} ${doctor.getSurname()}</p>
    <p><strong>Birthday: </strong>${doctor.getBirthday()}</p>
    <p><strong>Category: </strong>${category}</p>
    <p><strong>Email: </strong>${doctor.getEmail()}</p>
    <h4>Patients: </h4>
    <c:forEach items="${patients}" var="patient">
        <p><strong>Name: </strong>${patient.getName()} ${patient.getSurname()}</p>
    </c:forEach>
</body>
</html>
