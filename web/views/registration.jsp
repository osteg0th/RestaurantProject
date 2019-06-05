<%--
  Created by IntelliJ IDEA.
  User: rex
  Date: 5/27/2019
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<header class="header">
    <%--<jsp:include page="_menu.jsp"></jsp:include>    ne rabotaet--%>
</header>
<div class="wrapper">

    <form class="registration form" action="${pageContext.request.contextPath}/" method="post">
        <label for="email">Email: </label>
        <input type="text" name="email" id="email">
        <label for="password">Password: </label>
        <input type="password" name="password" id="password">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <label for="surname">Surname</label>
        <input type="text" name="surname" id="surname">
        <input type="submit" name="signup" value="Sign up!">
    </form>
    <a class="button" href="${pageContext.request.contextPath}/login">Sign in</a>
</div>
</body>
</html>
