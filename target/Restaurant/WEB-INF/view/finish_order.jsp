<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/css/style.css" />" />
    <title>TheRestaurant</title>
</head>
<script type='text/javascript'
        src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>
<script type="text/javascript" src="<c:url value="/js/menu.js" />"></script>
<body>
<c:set var='view' value='finish_order' scope='session' />

<!-- language manager -->
<%@include file="lang.jsp"%>

<div id="main">
    <div id="logo">
        <img src="<c:url value="/img/logo.jpg" />" width="50%" />
    </div>
    <div>
        <h1 style="font-color: #f9bb12">
            <fmt:message key="welcome" />
        </h1>
    </div>
    <div id="form">
        <div id="profile">
            <img src="\img\customer1.png" width="20" height="20" />
            <c:out value="${customer.login}" />

            <form action="<c:url value="profile" />" method="post">
                <input type="submit" class="css3button1"
                       value="<fmt:message key="view_profile" />"/>
            </form>
            <form action="<c:url value="logout" />" method="post">
                <input type="submit" class="css3button1"
                       value="<fmt:message key="logout" />"/>
            </form>
        </div>
        <div id="menu">
            <div id="finish_order">
                <c:out value="${customer.login}" />
                <fmt:message key="order_success" />
                <fmt:message key="wait" />
            </div>
            <form action="<c:url value="do_another_order" />" method="post">
                <input type="submit" class="css3button"
                       value="<fmt:message key="do_another_order" />"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>