<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/css/style.css" />" />
    <title>Restaurant</title>
</head>
<body>
<c:set var='view' value='admin' scope='session'/>

<%@include file="lang.jsp"%>

<div id="main">
    <div id="logo">
        <a href="<c:url value="/index.jsp" />"><img src="\img\logo.jpg"
                                                   width="50%" /></a>
    </div>
    <div>
        <h1>
            <br>
            <fmt:message key="welcome" />
        </h1>
    </div>
    <div id="form">
        <div id="admin_console">
            <fmt:message key="admin_console" />
        </div>
        <h2>
            <c:if test="${invalidAdminLogin != null}">
                <fmt:message key="incorrect_pass_or_login"/>
            </c:if>
        </h2>
        <form action="<c:url value="admin_login"/>" method="post">
            <br>
            <div id="la"><fmt:message key="login" />:</div>
            <div id="pa"><fmt:message key="password" />:</div>
            <input type="text" name="login" class="css3login" /><br> <input
                type="password" name="password" class="css3password" /> <br>
            <input type="submit" value="<fmt:message key="login_submit" />"
                   class="css3button" />
        </form>
    </div>
</div>
</body>
</html>
