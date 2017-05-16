<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/tabletag.tld" prefix="mytag"%>
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/css/style.css" />" />
    <title>Insert title here</title>
</head>
<body>
<c:set var='view' value='profile' scope='session' />

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
    <div id="viewprofile">
        <table class="tab">
            <tr>
                <td><fmt:message key="customer_login" /></td>
                <td><fmt:message key="customer_email" /></td>
                <td><fmt:message key="customer_phone" /></td>
            </tr>
            <mytag:table customer_phone="${customer.phone}"
                         customer_login="${customer.login}"
                         customer_email="${customer.email}" />
        </table>
        <br>
        <div id="backtomenu2">
            <form action="<c:url value="back"/>" method="post">
                <input type="submit" value="<fmt:message key="back_to_menu" />"
                       class="css3button" />
            </form>
        </div>
    </div>
</div>

</body>
</html>