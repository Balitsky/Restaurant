<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url value="/css/style.css" />"/>
    <title>TheRestaurant</title>
</head>
<script type='text/javascript'
        src='http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js'></script>
<script type="text/javascript" src="<c:url value="/js/menu.js" />"></script>
<body>

<c:set var='view' value='viewcart' scope='session'/>


<!-- language manager -->
<%@include file="lang.jsp" %>

<div id="main">
    <div id="logo">
        <img src="<c:url value="/img/logo.jpg" />" width="50%"/>
    </div>
    <div>
        <h1 style="font-color: #f9bb12">
            <fmt:message key="welcome"/>
        </h1>
    </div>
    <div id="form">
        <div id="profile">
            <img src="\img\customer1.png" width="20" height="20"/>
            <c:out value="${customer.login}"/>

            <form action="<c:url value="profile" />" method="post">
                <input type="submit" class="css3button1"
                       value="<fmt:message key="view_profile" />"/>
            </form>
            <form action="<c:url value="logout" />" method="post">
                <input type="submit" class="css3button1"
                       value="<fmt:message key="logout" />"/>
            </form>
        </div>
        <div id="hello">
            <div id="bucket">
                <c:out value="${items_count}"/>
                <fmt:message key="items"/>
                <br>

                <c:choose>
                    <c:when test="${items_count eq 0}">
                        <img src="<c:url value="/img/empty_cart.png" /> " width="32"
                             height="32" style="padding-right: 50px;"/>
                    </c:when>
                    <c:when test="${items_count ne 0}">
                        <img src="<c:url value="/img/full_cart.png" /> " width="32"
                             height="32" style="padding-right: 50px;"/>
                    </c:when>
                </c:choose>
            </div>
            <div id="fin">
                <form action="<c:url value="finish_order" />" method="post">
                    <img src="/img/finish.png" width="32" height="32"/>
                    <div id="sum"><fmt:message key="total"/><br>&euro; <c:out value="${order.total}"/></div>
                    <div id="fin_but"><input type="submit" value="<fmt:message key="finish_the_order" />"
                                             class="css3button"/></div>
                </form>
            </div>
            <div id="total">
                <c:if test="${incorrect_update_value_msg ne null}">
                    <fmt:message key="incorrect_update_value"/>
                </c:if>
                <c:if test="${exceeded_value ne null}">
                    <fmt:message key="exceeded_value"/>
                </c:if>
                <c:if test="${empty_cart ne null}">
                    <fmt:message key="empty_basket"/>
                </c:if>
                <br>
            </div>
        </div>
        <div id="menu_cart">
            <br>
            <table class="tab">
                <tr>
                    <td><fmt:message key="product_name"/></td>
                    <td><fmt:message key="product_price"/></td>
                    <td align="center"><fmt:message key="product_quantity"/></td>
                    <td align="center"><fmt:message key="remove"/></td>
                </tr>
                <c:forEach items="${order.accountProduct}" var="item">
                    <tr id="cart_info">
                        <td><c:out value="${item.key.name}"/></td>
                        <td>&euro;<c:out value="${item.key.price}"/></td>
                        <td>
                            <form action="<c:url value="updatequantity"/>" method="post">
                                <input type="text" class="areatext"
                                       value="<c:out value="${item.value}" />"
                                       name="update_value">
                                <input type="submit" class="greenbutton"
                                       value="<fmt:message key="update" />"/>
                                <input type="hidden" name="prod_name" value="${item.key.name}">
                            </form>
                        </td>
                        <td>
                            <form action="<c:url value="remove_product"/>" method="post">
                                <input type="submit" class="redbutton"
                                       value="<fmt:message key="remove" />"> <input
                                    type="hidden" name="remove_name" value="${item.key.name}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
            </table>
        </div>
        <div id="backtomenu">
            <form action="<c:url value="back"/>" method="post">
                <input type="submit" value="<fmt:message key="back_to_menu" />"
                       class="css3button"/>
            </form>
        </div>
    </div>
</div>
</body>
</html>