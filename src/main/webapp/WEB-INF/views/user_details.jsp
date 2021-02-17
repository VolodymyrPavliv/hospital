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

    <title><fmt:message key="userDetailsPage"/></title>
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
            <a class="navbar-brand" href="<c:url value="/admin"/>"><fmt:message key="hospital"/></a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/admin"/>"><fmt:message key="adminPage"/></a>
                </li>
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
                    <span class="subheading"><fmt:message key="userDetailsPage"/></span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <div class="post-preview">
            <c:if test="${doctorId != null}">
                <p><strong><fmt:message key="doctorId"/> </strong>${doctorInfoId}</p>
            </c:if>
            <p><strong><fmt:message key="userId"/> </strong>${user.getId()}</p>
            <p><strong><fmt:message key="name"/> </strong>${user.getName()} ${user.getSurname()}</p>
            <c:if test="${doctorId != null}">
                <p><strong><fmt:message key="category"/>: </strong>${category}</p>
            </c:if>
            <p><strong><fmt:message key="dateOfBirth"/> </strong>${user.getBirthday()}</p>
            <p><strong><fmt:message key="email"/> </strong>${user.getEmail()}</p>
        </div>

        <c:if test="${patientId!=null}">
            <hr>
            <div class="post-preview">
                <button data-toggle="collapse" data-target="#addRecord" class="btn-secondary btn-link"><h2><fmt:message key="addRecord"/></h2></button>

                <div id="addRecord" class="collapse">
                    <form action="/addRecord" method="post">
                        <input type="hidden" name="userId" value="${patientId}"/>
                        <label for="doctorId"> <fmt:message key="enterDoctorId"/>   </label>
                        <input type="text" id="doctorId" class="input-sm" name="doctorId"/><br><br>
                        <label for="nurseId" > <fmt:message key="enterNurseId"/>       </label>
                        <input type="text" id="nurseId" name="nurseId" class="input-sm"/><br><br>
                        <label for="entryDateId"> <fmt:message key="enterEntryDate"/> </label>
                        <input type="date" name="entryDate" id="entryDateId"/><br><br>
                        <button type="submit" class="btn-secondary btn-danger">
                            <fmt:message key="add"/></button>
                    </form>
                </div>
            </div>
        </c:if>
        <hr>
        <div class="post-preview">
            <button data-toggle="collapse" data-target="#records" class="btn-secondary btn-link"><h2><fmt:message key="records"/></h2></button>
            <div id="records" class="collapse">
                <c:if test="${records.size()==0}">
                    <h3><fmt:message key="noRecords"/></h3>
                </c:if>
                <c:forEach items="${records}" var="record">
                    <p><strong><fmt:message key="entryDate"/> </strong>${record.getEntryDate()}</p>
                    <p><strong><fmt:message key="diagnosis"/> </strong>${record.getInitialDiagnosis()}</p>
                    <form action="/adminRecord" method="get">
                        <input type="hidden" name="recordId" value="${record.getId()}">
                        <button type="submit" class="btn-secondary btn-danger">
                            <fmt:message key="details"/></button>
                    </form>
                    <hr>
                </c:forEach>
            </div>
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