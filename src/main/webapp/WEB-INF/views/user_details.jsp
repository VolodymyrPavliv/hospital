<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <p>${user.getName()} ${user.getSurname()}</p>
    <c:if test="${doctorId != null}">
        <p><strong>Category: </strong>${category}</p>
    </c:if>
    <p><strong>Birthday: </strong>${user.getBirthday()}</p>
    <p><strong>Email: </strong>${user.getEmail()}</p>

    <c:if test="${patientId!=null}">
    ----------------------------------------------------------
    <p><strong>Add new record</strong></p>
        <form action="/admin/addRecord" method="post">
            <input type="hidden" name="patientId" value="${patientId}"/>
            <label for="doctorId"> Enter doctor id:   </label>
            <input type="text" id="doctorId" name="doctorId"/><br><br>
            <label for="nurseId"> Enter nurse id:      </label>
            <input type="text" id="nurseId" name="nurseId"/><br><br>
            <label for="entryDateId"> Enter entry date: </label>
            <input type="date" name="entryDate" id="entryDateId"/><br><br>
            <input type="submit" value="Add a new record"/>
        </form>
    </c:if>
    -----------------------------------------------------------
    <p><strong>Records</strong></p>
    -----------------------------------------------------------
    <c:forEach items="${records}" var="record">
        <p><strong>Date: </strong>${record.getEntryDate()}</p>
        <p><strong>Diagnosis: </strong>${record.getInitialDiagnosis()}</p>
        <form action="/admin/record" method="get">
            <input type="hidden" name="id" value="${record.getId()}"/>
            <input type="submit" value="Details"/>
        </form>
    </c:forEach>
</body>
</html>
