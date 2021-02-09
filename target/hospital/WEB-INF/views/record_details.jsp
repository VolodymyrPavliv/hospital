<%--
  Created by IntelliJ IDEA.
  User: Volodymyr
  Date: 09.02.2021
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Record details</title>
</head>
<body>
    <p><strong>Patient: </strong> ${patient.getName()} ${patient.getSurname()}</p>
    <p><strong>Entry date: </strong> ${record.getEntryDate()}</p>
    <p><strong>Discharge date: </strong> ${record.getDischargeDate()}</p>
    <p><strong>Initial diagnosis: </strong> ${record.getInitialDiagnosis()}</p>
    <p><strong>Final diagnosis: </strong> ${record.getFinalDiagnosis()}</p>
    ---------------------------------------------------------------------------
    <p><strong>Doctor: </strong> ${doctor.getName()} ${doctor.getSurname()}</p>
    <p><strong>Category: </strong> ${doctorInfo.getCategory()}</p>
    ---------------------------------------------------------------------------
    <p><strong>Nurse: </strong> ${nurse.getName()} ${nurse.getSurname()}</p>
</body>
</html>
