
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/css/style.css" />
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <title>Error</title>
</head>
<body>
<%@include file="lang.jsp"%>

<div id="main">
    <div id="logo">
        <img src="/img/logo.jpg" width="50%" />
    </div>
    <div id="error">
        <h1 style="font-color: #f9bb12">
            <fmt:message key="welcome" />
        </h1>
    </div>
    <div id="form_error">
        <p>ERROR</p>
    </div>
    <div id="goback">
        <a href="index.jsp"><fmt:message key="back_to_main" /></a>
    </div>
</div>
</body>
</html>