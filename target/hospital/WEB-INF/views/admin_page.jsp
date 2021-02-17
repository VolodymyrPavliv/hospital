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

    <title><fmt:message key="adminPage"/> </title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="resources/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700' rel='stylesheet' type='text/css'>
</head>

<body style="background-color: #6df1f6">

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
                <li>
                    <form>
                        <select id="language" name="language" onchange="submit()">
                            <option  value="en" ${language == 'en' ? 'selected' : ''}>en</option>
                            <option  value="ua" ${language == 'ua' ? 'selected' : ''}>укр</option>
                        </select>
                    </form>
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
                    <span class="subheading"><fmt:message key="adminPage"/></span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#unregisteredUsers" class="btn-secondary btn-link">
            <h2><fmt:message key="unregisteredUsers"/></h2></button>

        <div id="unregisteredUsers" class="collapse">
            <c:if test="${unregisteredUsers.size()==0}">
                <h3><fmt:message key="noUnregisteredUsers"/></h3>
            </c:if>
        <c:forEach items="${unregisteredUsers}" var="user">
            <br>
            <strong><fmt:message key="userN"/>${user.id}:</strong>  ${user.getName()} ${user.getSurname()}<br>
            <br>
            <form action="/registerUser" method="post">
                <input type="hidden" name="doctorId" value="${user.getId()}"/>
                <input type="text" name="category" placeholder="Enter category"/>
                <button class="btn-secondary btn-danger" type="submit"><fmt:message key="regAsDoc"/></button>
            </form>
            <br>
            <form action="/registerUser" method="post">
                <button class="btn-secondary btn-danger" type="submit" name ="nurseId" value="${user.getId()}" ><fmt:message key="regAsNurse"/></button>
                <button class="btn-secondary btn-danger" type="submit" name ="patientId" value="${user.getId()}"><fmt:message key="regAsPatient"/></button>
            </form>
        </c:forEach>
        </div>
    </div>
    <hr>
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#doctors" class="btn-secondary btn-link"><h2><fmt:message key="doctors"/></h2></button>

        <div id="doctors" class="collapse">
            <c:if test="${doctors.size()==0}">
                <h3><fmt:message key="noDoc"/></h3>
            </c:if>
            <form action="/admin">
            <select name="type">
                <option value="0" disabled selected><fmt:message key="chooseSorting"/></option>
                <option value="1"><fmt:message key="alphabet"/></option>
                <option value="2"><fmt:message key="category"/></option>
            </select>
            <button type="submit" class="btn-secondary btn-danger">
                <strong><fmt:message key="sort"/></strong>
            </button>
        </form>
        <c:forEach items="${doctors}" var="user">
            <form action="/user">
                <button type="submit" name="userId" value="${user.getId()}" class="btn-danger btn-link">
                <strong><fmt:message key="userN"/>${user.id}:</strong> ${user.getName()} ${user.getSurname()}</button>
            </form>
        </c:forEach>
        </div>
    </div>
    <hr>
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#nurses" class="btn-secondary btn-link"><h2><fmt:message key="nurses"/></h2></button>
        <div id="nurses" class="collapse">
            <c:if test="${nurses.size()==0}">
                <h3><fmt:message key="noNurses"/></h3>
            </c:if>
            <form action="/admin">
            <select name="type">
                <option value="0" disabled selected><fmt:message key="chooseSorting"/></option>
                <option value="3"><fmt:message key="alphabet"/></option>
                <option value="4"><fmt:message key="category"/></option>
            </select>
            <button class="btn-secondary btn-danger"type="submit">
                <strong><fmt:message key="sort"/></strong>
            </button>
        </form>
        <c:forEach items="${nurses}" var="user">
            <form action="/user">
                <button class="btn-danger btn-link" name="userId" value="${user.getId()}" type="submit">
                    <strong><fmt:message key="userN"/>${user.id}:</strong> ${user.getName()} ${user.getSurname()}</button>
            </form>
        </c:forEach>
        </div>
    </div>
    <hr>
    <div class="post-preview">
        <button data-toggle="collapse" data-target="#patients" class="btn-secondary btn-link"><h2><fmt:message key="patients"/></h2></button>
        <div id="patients" class="collapse">
            <c:if test="${patients.size()==0}">
                <h3><fmt:message key="noPatients"/></h3>
            </c:if>
            <form action="/admin">
            <select name="type" >
                <option value="0" disabled selected><fmt:message key="chooseSorting"/></option>
                <option value="5"><fmt:message key="alphabet"/></option>
                <option value="6"><fmt:message key="category"/></option>
            </select>
            <button class="btn-secondary btn-danger" type="submit">
                <strong><fmt:message key="sort"/></strong>
            </button>
        </form>
        <c:forEach items="${patients}" var="user">
            <form action="/user">
                <button class="btn-danger btn-link" type="submit" name="userId" value="${user.getId()}">
                    <strong><fmt:message key="userN"/>${user.id}:</strong> ${user.getName()} ${user.getSurname()}</button>
            </form>
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