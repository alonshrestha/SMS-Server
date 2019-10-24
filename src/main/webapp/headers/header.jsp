<%@ page import="np.com.alon.enumlist.HttpRequestList" %>

<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <!-- Latest compiled and minified CSS -->--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>

<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>

<%--    <!-- Optional theme -->--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">--%>

<%--    <!-- Latest compiled and minified JavaScript -->--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>
<%--    <style>--%>
<%--        body {--%>
<%--            font-family: "Lato", sans-serif;--%>
<%--        }--%>

<%--        .sidenav {--%>
<%--            height: 100%;--%>
<%--            width: 160px;--%>
<%--            position: fixed;--%>
<%--            z-index: 1;--%>
<%--            top: 0;--%>
<%--            left: 0;--%>
<%--            background-color: #111;--%>
<%--            overflow-x: hidden;--%>
<%--            padding-top: 20px;--%>
<%--        }--%>

<%--        .sidenav a {--%>
<%--            padding: 6px 8px 6px 16px;--%>
<%--            text-decoration: none;--%>
<%--            font-size: 25px;--%>
<%--            color: #818181;--%>
<%--            display: block;--%>
<%--        }--%>

<%--        .sidenav a:hover {--%>
<%--            color: #f1f1f1;--%>
<%--        }--%>

<%--        .main {--%>
<%--            margin-left: 160px; /* Same as the width of the sidenav */--%>
<%--            font-size: 28px; /* Increased text to enable scrolling */--%>
<%--            padding: 0px 10px;--%>
<%--        }--%>

<%--        @media screen and (max-height: 450px) {--%>
<%--            .sidenav {padding-top: 15px;}--%>
<%--            .sidenav a {font-size: 18px;}--%>
<%--        }--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="sidenav">--%>
<%--    <a href="${pageContext.request.contextPath}/students?action=${HttpRequestList.ALL.toString()}">Student</a>--%>
<%--    <a href="${pageContext.request.contextPath}/messageList?action=${HttpRequestList.ALL.toString()}">Message Template</a>--%>
<%--    <a href="${pageContext.request.contextPath}/grades?action=${HttpRequestList.ALL.toString()}">Grades</a>--%>
<%--    <a href="#contact">Contact</a>--%>
<%--</div>--%>



<%--</body>--%>
<%--</html>--%>


<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SMS Server</title>

    <style type="text/css">

        <%@include file="../Design/sidebar-style/css/simple-sidebar.css" %>
        <%@include file="../Design/sidebar-style/vendor/bootstrap/css/bootstrap.min.css" %>

    </style>
    <script type="text/javascript">
        <%@include file="../Design/sidebar-style/vendor/jquery/jquery.min.js" %>
        <%@include file="../Design/sidebar-style/vendor/bootstrap/js/bootstrap.bundle.min.js" %>
    </script>

</head>

<body>

<div class="d-flex" id="wrapper">

    <!-- Sidebar -->
    <div class="bg-light border-right" id="sidebar-wrapper">
        <div class="sidebar-heading"><a href="${pageContext.request.contextPath}/">SMS Server Dashboard</a> </div>
        <div class="list-group list-group-flush">

            <a href="${pageContext.request.contextPath}/students?action=${HttpRequestList.ALL.toString()}" class="list-group-item list-group-item-action bg-light">Student</a>
            <a href="${pageContext.request.contextPath}/messageList?action=${HttpRequestList.ALL.toString()}" class="list-group-item list-group-item-action bg-light">Message Templates</a>
            <a href="${pageContext.request.contextPath}/grades?action=${HttpRequestList.ALL.toString()}" class="list-group-item list-group-item-action bg-light">Grades</a>
            <a href="${pageContext.request.contextPath}/connectionPorts?action=${HttpRequestList.ALL.toString()}" class="list-group-item list-group-item-action bg-light">Port Setting</a>
            <a href="${pageContext.request.contextPath}/mmm?action=${HttpRequestList.DIRECT_MESSAGE.toString()}" class="list-group-item list-group-item-action bg-light">Direct Message</a>
            <a href="${pageContext.request.contextPath}/mmm?action=${HttpRequestList.MESSAGE_FROM_TEMPLATE.toString()}" class="list-group-item list-group-item-action bg-light">Message From Template</a>
<%--            <a href="../login.jsp" class="list-group-item list-group-item-action bg-light">Login </a>--%>

        </div>
    </div>

    <div id="page-content-wrapper">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
<%--            <button class="btn btn-primary" id="menu-toggle">Toggle Menu</button>--%>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
<%--                    <li class="nav-item active">--%>
<%--                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>--%>
<%--                    </li>--%>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Account
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
                            <div class="dropdown-divider"></div>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>

