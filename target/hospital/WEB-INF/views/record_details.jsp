<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="resources"/>

<html lang="${language}">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="recordDetailsPage"/></title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="resources/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700' rel='stylesheet' type='text/css'>

</head>

<body style="
background-color: #6df1f6">

<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="<c:url value="#"/>"><fmt:message key="hospital"/></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${isAdmin != null}">
                <li>
                    <a href="<c:url value="/admin"/>"><fmt:message key="adminPage"/></a>
                </li>
                </c:if>
                <c:if test="${isPatient != null}">
                    <li>
                        <a href="<c:url value="/patient"/>"><fmt:message key="patientPage"/></a>
                    </li>
                </c:if>
                <c:if test="${isDoctor != null}">
                    <li>
                        <a href="<c:url value="/doctor"/>"><fmt:message key="doctorPage"/></a>
                    </li>
                </c:if>
                <c:if test="${isNurse != null}">
                    <li>
                        <a href="<c:url value="/nurse"/>"><fmt:message key="nursePage"/></a>
                    </li>
                </c:if>
                <li>
                    <a href="<c:url value="#"/>"><fmt:message key="aboutUs"/></a>
                </li>
                <li>
                    <a href="<c:url value="#"/>"><fmt:message key="contactUs"/></a>
                </li>
                <li>
                    <a href="<c:url value="/logout"/>"><fmt:message key="logout"/></a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<header class="intro-header" style="
background-color: #6df1f6; background-image: url('../../resources/img/home-page.jpg')">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <div class="site-heading">
                    <h1><fmt:message key="hospital"/></h1>
                    <hr class="small">
                    <span class="subheading"><fmt:message key="recordDetailsPage"/></span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <h2 class="text-center"><fmt:message key="recordDetailsPage"/></h2>
        <hr>
        <c:if test="${isDoctor!=null}">
        <div class="post-preview">
            <button data-toggle="collapse" data-target="#initialDiagnosis" class="btn-secondary btn-link">
                <h3><fmt:message key="addInitialDiagnosis"/></h3></button>
            <div id="initialDiagnosis" class="collapse">
                <form action="/addInitDiagnosis" method="post">
                    <input type="hidden" name="id" value="${record.getId()}">
                    <textarea name="initialDiagnosis"></textarea>
                    <button type="submit" class="btn-secondary btn-danger">
                        <fmt:message key="add"/></button>
                </form>
            </div>
            <br>
            <button data-toggle="collapse" data-target="#finalDiagnosis" class="btn-secondary btn-link">
                <h3><fmt:message key="addFinalDiagnosis"/></h3></button>
            <div id="finalDiagnosis" class="collapse">
                <form action="/addFinalDiagnosis" method="post">
                    <label for="discharge"><fmt:message key="dischargeDate"/></label>
                    <input type="date" name="dischargeDate" id="discharge"><br>
                    <input type="hidden" name="id" value="${record.getId()}">
                    <textarea name="finalDiagnosis"></textarea><br><br>
                    <button type="submit" class="btn-secondary btn-danger">
                        <fmt:message key="add"/></button>
                </form>
            </div>
        </div>
            <hr>
        </c:if>
        <div class="post-preview">
            <p><strong><fmt:message key="patient"/> </strong> ${patient.getName()} ${patient.getSurname()}</p>
            <p><strong><fmt:message key="entryDate"/> </strong> ${record.getEntryDate()}</p>
            <p><strong><fmt:message key="dischargeDate"/> </strong> ${record.getDischargeDate()}</p>
            <p><strong><fmt:message key="initialDiagnosis"/> </strong> ${record.getInitialDiagnosis()}</p>
            <p><strong><fmt:message key="finalDiagnosis"/> </strong> ${record.getFinalDiagnosis()}</p>
            <hr>
            <p><strong><fmt:message key="doctor"/> </strong> ${doctor.getName()} ${doctor.getSurname()}</p>
            <p><strong><fmt:message key="category"/>: </strong> ${doctorInfo.getCategory()}</p>
            <hr>
            <p><strong><fmt:message key="nurse"/> </strong> ${nurse.getName()} ${nurse.getSurname()}</p>
        </div>
        <hr>
        <div class="post-preview">
            <c:if test="${isAdmin}">
            <form action="/assignmentList">
                <input type="hidden" name="recordId" value="${record.getId()}">
                <button class="btn-secondary btn-link">
                    <h2><fmt:message key="assignments"/></h2></button>
            </form>
            </c:if><c:if test="${isDoctor}">
            <form action="/doctorAssignments">
                <input type="hidden" name="recordId" value="${record.getId()}">
                <button class="btn-secondary btn-link">
                    <h2><fmt:message key="assignments"/></h2></button>
            </form>
            </c:if>
            <c:if test="${isNurse}">
            <form action="/nurseAssignments">
                <input type="hidden" name="recordId" value="${record.getId()}">
                <button class="btn-secondary btn-link">
                    <h2><fmt:message key="assignments"/></h2></button>
            </form>
            </c:if>
            <c:if test="${isPatient}">
                <form action="/patientAssignments">
                    <input type="hidden" name="recordId" value="${record.getId()}">
                    <button class="btn-secondary btn-link">
                        <h2><fmt:message key="assignments"/></h2></button>
                </form>
            </c:if>
        </div>
    </div>
</div>

<hr>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <p class="copyright text-muted">Hospital &copy;  2021</p>
        </div>
    </div>
</footer>
<!-- jQuery -->
<script src="resources/js/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="resources/js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<script src="resources/js/jqBootstrapValidation.js"></script>
<script src="resources/js/contact_me.js"></script>

<!-- Theme JavaScript -->
<script src="resources/js/clean-blog.min.js"></script>
</body>
</html>
