<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="css/style.css" />" />
    <title>Restaurant</title>
</head>
<body>
<c:set var='view' value='reg' scope='session' />

<%@include file="WEB-INF/view/lang.jsp"%>

<div id="main">
    <div id="logo">
        <img src="<c:url value="img/logo.jpg" />" width="50%" />
    </div>
    <div>
        <h1 style="font-color: #f9bb12">
            <br>
            <fmt:message key="welcome" />
        </h1>
    </div>
    <div id="form2">
        <div id="regres">
            <h2>
                <c:if test="${filledFail ne null}">
                    <fmt:message key="not_all_fields_are_filled"/>
                </c:if>
                <c:if test="${emailFail ne null}">
                    <fmt:message key="incorrect_email"/>
                </c:if>
                <c:if test="${loginFail ne null}">
                    <fmt:message key="incorrect_login"/>
                </c:if>
                <c:if test="${passwordFail ne null}">
                    <fmt:message key="incorrect_password"/>
                </c:if>
                <c:if test="${phoneFail ne null}">
                    <fmt:message key="incorrect_phone"/>
                </c:if>
                <c:if test="${confirmpassFail ne null}">
                    <fmt:message key="passwords_dont_match"/>
                </c:if>
                <c:if test="${alreadyUser ne null}">
                    <fmt:message key="already_user"/>
                </c:if>
            </h2>
        </div>
        <form action="<c:url value="reg" />" method="post" enctype="multipart/form-data; charset=utf-8">
            <br>
            <fmt:message key="login" />: <input type="text" name="login" class="css3login" value="${login}"/><br>
            <fmt:message key="password" />: <input type="password" name="password" class="css3login" /><br>
            <fmt:message key="confirm_password" />: <input type="password" name="confirm_password" class="css3login" /><br>
            <fmt:message key="phone" />: <input type="text" name="phone" value="${phone}" class="css3login" />
            <span style="color: gray;"> (<fmt:message key="example" />:0993256678)</span><br>
            <fmt:message key="email" />: <input type="text" name="email" value="${email}" class="css3login" /><br>
            <input type="submit" value="<fmt:message key="registration_submit" />" class="css3button" />
            <div id="back">
                <a href="index.jsp"><fmt:message key="back_to_main" /></a>
            </div>
        </form>

    </div>
</div>
</body>
</html>
