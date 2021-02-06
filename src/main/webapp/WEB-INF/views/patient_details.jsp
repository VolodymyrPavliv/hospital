<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient Details</title>
</head>
<body>
    <p>${patient.getName()} ${patient.getSurname()}</p>
    <p><strong>Birthday: </strong>${patient.getBirthday()}</p>
    <p><strong>Email: </strong>${patient.getEmail()}</p>
    <p><strong>Doctor: </strong>${doctor.getName()} ${doctor.getSurname()}</p>
    <p><strong>Nurse: </strong>${nurse.getName()} ${nurse.getSurname()}</p>
</body>
</html>
