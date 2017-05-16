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

<c:set var='view' value='admin_console' scope='session' />

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
        <div id="admin_console">
            <fmt:message key="admin_console" />
        </div>
        <div id="profile_admin">
            <img src="<c:url value="/img/customer1.png" />" width="20"
                 height="20" />
            <c:out value="${admin.login}" />
            <form action="<c:url value="view_all_customers"/>" method="post">
                <input type="submit" class="css3button3"
                       value="<fmt:message key="view_all_customers" />"/>
            </form>
            <form action="<c:url value="view_all_orders"/>" method="post">
                <input type="submit" class="css3button3"
                       value="<fmt:message key="view_all_orders" />"/>
            </form>
            <form action="<c:url value="logout_admin"/>" method="post">
                <input type="submit" class="css3button3"
                       value="<fmt:message key="logout" />"/>
            </form>
        </div>
    </div>
    <div id="form1">
        <div id="confirm_msg">
            <c:if test="${confirm_succes ne null}">
                <fmt:message key="confirm_order"/>
            </c:if>
        </div>
        <c:if test="${list_customers ne null}">
            <table class="tab1">
                <tr>
                    <td><fmt:message key="customer_id" /></td>
                    <td><fmt:message key="customer_login" /></td>
                    <td><fmt:message key="customer_email" /></td>
                    <td><fmt:message key="customer_phone" /></td>
                </tr>
                <c:forEach items="${list_customers}" var="customer">
                    <tr id="profile_info">
                        <td><c:out value="${customer.idCustomer}" /></td>
                        <td><c:out value="${customer.login}" /></td>
                        <td><c:out value="${customer.email}" /></td>
                        <td><c:out value="${customer.phone}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${list_orders ne null}">
            <table class="tab1">
                <tr>
                    <td><fmt:message key="order_id" /></td>
                    <td><fmt:message key="order_customer" /></td>
                    <td><fmt:message key="order_total" /></td>
                    <td align="center"><fmt:message key="order_confirm" /></td>
                </tr>
                <c:forEach items="${list_orders}" var="order">
                    <tr id="profile_info">
                        <td><c:out value="${order.idOrder}" /></td>
                        <td><c:out value="${order.customer.login}" /></td>
                        <td><c:out value="${order.total}" /></td>
                        <td>
                            <form action="<c:url value="confirm_order"/>" method="post">
                                <input type="submit" class="greenbutton" value="<fmt:message key="confirm"/>" id="confirm_button"/>
                                <input type="hidden" name="id_order"
                                       value="<c:out value="${order.idOrder}"/>" />
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
</body>
</html>