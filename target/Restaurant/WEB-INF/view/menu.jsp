<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language}">
<head>
    <meta http-equiv="Content-Type" content="text/html;
charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="<c:url
value="/css/style.css" />"/>
    <title>TheRestaurant</title>
</head>
<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js'
        type='text/javascript'></script>
<script type="text/javascript" src="<c:url value="/js/menu.js"/>"></script>
<%-- <script type="text/javascript" src="<c:url value="js/jquery.js"/>"></script> --%>

<!-- language manager -->
<%@include file="lang.jsp"%>

<body>
<c:set var='view' value='menu' scope='session'/>


<div id="main">
    <div id="logo">
        <img src="<c:url
value="/img/logo.jpg" />" width="50%"/>
    </div>

    <h1>
        <fmt:message key="welcome" />
    </h1>

    <div id="form">
        <div id="profile">
            <img src="<c:url value="/img/customer1.png" />" width="20"
                 height="20"/>
            <c:out value="${customer.login}"/>
            <form action="<c:url value="profile"/>" method="post">
                <input type="submit" class="css3button1"
                       value="<fmt:message key="view_profile" />"/>
            </form>
            <form action="<c:url value="logout"/>" method="post">
                <input type="submit" class="css3button1"
                       value="<fmt:message key="logout" />"/>
            </form>
        </div>

        <div id="hello">
            <div id="bucket">
                <c:out value="${items_count}"/>
                <fmt:message key="items" />
                <br>
                <form action="<c:url value="viewcart"/>" method="post">
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
                    <input type="submit" class="css3button"
                           value="<fmt:message key="view_basket" />"/>
                </form>
            </div>
            <div id="NAP">
                <c:if test="${notAvailableProduct != null}">
                    <fmt:message key="product_not_available" />
                </c:if>
                <c:if test="${already_added != null}">
                    <fmt:message key="product_already_added" />
                </c:if>
            </div>
        </div>
        <div id="menu">
            <br>
            <div class="accordion">
                <c:forEach items="${list_categories}" var="category">
                    <h3>
                        <c:out value="${category.name}"/>
                        <c:choose>
                            <c:when test="${category.name eq 'meat'}">
                                <div id="meat">
                                    <img src="/img/meat.png"/>
                                </div>
                            </c:when>
                            <c:when test="${category.name eq 'beer'}">
                                <div id="beer">
                                    <img src="/img/beer.png"/>
                                </div>
                            </c:when>
                            <c:when test="${category.name eq 'fruits'}">
                                <div id="fruits">
                                    <img src="/img/apple.png"/>
                                </div>
                            </c:when>
                        </c:choose>
                    </h3>
                    <div class="content">
                        <table border=0 cellpadding=0 cellspacing=15>
                            <c:forEach items="${category.products}" var="product">
                                <tr>
                                    <td><c:out value="${product.name}"/></td>
                                    <td>&euro;<c:out value="${product.price}"/></td>
                                    <td>
                                        <form action="<c:url value="cart"/>" method="post">
                                            <input type="submit" value="add to cart" class="css3button2"/>
                                            <input type="hidden" name="id_product" value=<c:out value="${product.idProduct}"/>/>
                                            <input type="hidden" name="id_category" value=
                                                <c:out value="${category.idCategory}"/>/>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<script>
    var id = <c:out value="${idcat}" /> -1;
    if (id !== -1) {
        $(".accordion h3").eq(id).addClass("active");
        $(".accordion .content").eq(id).show();
    }
    ;
</script>
</body>
</html>