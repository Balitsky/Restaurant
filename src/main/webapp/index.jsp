<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="css/style.css" />"/>
    <title>Restaurant</title>
</head>
<body>
<c:set var='view' value='index' scope='session'/>

<%@include file="WEB-INF/view/lang.jsp"%>

<c:if test="${sessionScope.customer ne null}">
    <c:redirect url="login" />
</c:if>

<c:if test="${sessionScope.admin ne null}">
    <c:redirect url="admin_login" />
</c:if>

<div id="main">
    <div id="logo">
        <img src="/img/logo.jpg" width="50%" />
    </div>

    <h1>
        <br>
        <fmt:message key="welcome" />
    </h1>

    <div id="form">
        <h2>
            <c:if test="${invalidLogin ne null}">
                <fmt:message key="incorrect_pass_or_login"/>
            </c:if>
            <c:if test="${added_success ne null}">
                <fmt:message key="added_success"/>
            </c:if>
        </h2>
        <form action="<c:url value="login"/>" method="POST"
              enctype="multipart/form-data; charset=utf-8">
            <br>
            <div id="l"><fmt:message key="login" />:</div>
            <div id="p"><fmt:message key="password" />:</div>
            <input type="text" name="login" class="css3login" /> <br>
            <input type="password" name="password" class="css3password" /> <br>
            <input type="submit" value="<fmt:message key="login_submit" />" class="css3button" />
        </form>
        <div id="reg">
            <a href="<c:url value="reg.jsp" />"><%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%><fmt:message key="registration" /></a>
        </div>
    </div>
</div>
</body>
</html>
