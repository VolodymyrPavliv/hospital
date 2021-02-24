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

    <title><fmt:message key="userList"/></title>
    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="resources/css/clean-blog.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Ubuntu:400,700' rel='stylesheet' type='text/css'>
    <style>
        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .pagination a:active {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            transition: background-color .3s;
            border: 1px solid #ddd;
        }

        .pagination a:hover:not(.active) {background-color: #de2424;}
    </style>
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
                    <span class="subheading"><fmt:message key="patientList"/></span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <div class="post-preview">
            <h2 class="text-center"><fmt:message key="patientList"/></h2>
            <hr>
            <form action="/userList">
                    <select name="sortingType" >
                        <option value="0" disabled selected><fmt:message key="chooseSorting"/></option>
                        <option value="1"><fmt:message key="alphabet"/></option>
                        <option value="3"><fmt:message key="birthday"/></option>
                    </select>
                    <input type="hidden" name="listType" value="patientList">
                    <button class="btn-secondary btn-danger" type="submit">
                        <strong><fmt:message key="sort"/></strong>
                    </button>
                </form>
            <hr>
            <c:if test="${patients.size()==0}">
                <h3><fmt:message key="noPatients"/></h3>
            </c:if>
                <c:forEach items="${patients}" var="user">
                    <form action="/user">
                        <button class="btn-danger btn-link" type="submit" name="userId" value="${user.getId()}">
                            <strong><fmt:message key="userN"/>${user.id}:</strong> ${user.getName()} ${user.getSurname()}</button>
                    </form>
                </c:forEach>

            <div class="pagination">
            <c:if test="${currentPage != 1}">
                <a href="/userList?listType=patientList&currentPage=${currentPage - 1}&sortingType=${sortingType}">
                    <<</a>
            </c:if>

                <c:if test="${pages != 1}">
                    <c:forEach begin="1" end="${pages}" var="i">
                        <c:choose>
                            <c:when test="${currentPage eq i}">
                                <a href="#" style="background-color: #1b6d85">${i}</a>
                            </c:when>
                            <c:otherwise>
                                <a href="/userList?listType=patientList&currentPage=${i}&sortingType=${sortingType}">${i}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:if>

            <c:if test="${currentPage != pages}">
                <a href="/userList?listType=patientList&currentPage=${currentPage + 1}&sortingType=${sortingType}">>></a>
            </c:if>
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