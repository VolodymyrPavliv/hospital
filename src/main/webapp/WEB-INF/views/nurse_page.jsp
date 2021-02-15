<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8"%>

<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Nurse Page</title>
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
            <a class="navbar-brand" href="<c:url value="/nurse"/>">Hospital</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="<c:url value="/nurse"/>">Nurse Page</a>
                </li>
                <li>
                    <a href="<c:url value="#"/>">About us</a>
                </li>
                <li>
                    <a href="<c:url value="#"/>">Contact us</a>
                </li>
                <li>
                    <a href="<c:url value="/logout"/>">Logout</a>
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
                    <h1>Hospital</h1>
                    <hr class="small">
                    <span class="subheading">Nurse Page</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
        <div class="post-preview">
            <p><strong>User ID: </strong>${user.getId()}</p>
            <p><strong>Name: </strong>${user.getName()} ${user.getSurname()}</p>
            <p><strong>Date of birth: </strong>${user.getBirthday()}</p>
            <p><strong>Email: </strong>${user.getEmail()}</p>
        </div>
        <hr>
        <div class="post-preview">
            <button data-toggle="collapse" data-target="#records" class="btn-secondary btn-link"><h1>List of records</h1></button>
            <div id="records" class="collapse">
                <c:if test="${records.size()==0}">
                    <h3>There are no records.</h3>
                </c:if>
                <c:forEach items="${records}" var="record">
                    <p><strong>Date: </strong>${record.getEntryDate()}</p>
                    <p><strong>Diagnosis: </strong>${record.getInitialDiagnosis()}</p>
                    <form action="/nurseRecord">
                        <input type="hidden" name="recordId" value="${record.getId()}">
                        <button type="submit" class="btn-secondary btn-danger">
                            Details</button>
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