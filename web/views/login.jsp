<%--
  Created by IntelliJ IDEA.
  User: rex
  Date: 5/27/2019
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <title>Login</title>
</head>
<body>
<header class="header">
    <%--<jsp:include page="_menu.jsp"></jsp:include>    ne rabotaet--%>
</header>
<div class="wrapper">
    <form class="login form" action="${pageContext.request.contextPath}/AuthController" method="POST">
        <label for="email">Email: </label>
        <input type="text" name="login" id="email">
        <label for="password">Password: </label>
        <input type="password" name="password" id="password">
        <input type="submit" name="signin" value="Sign in!">
    </form>
    <a class="button" href="${pageContext.request.contextPath}/registration">Sign up</a>
</div>
<%--<h1>Huli ono ne rabotaet?</h1>--%>
<%--<h2>Сегодня: <%= new Date() %></h2>--%>
</body>
</html>
