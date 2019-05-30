<%--
  Created by IntelliJ IDEA.
  User: rex
  Date: 5/27/2019
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<div class="wrapper">
    <form class="login form" action="${pageContext.request.contextPath}/" method="post">
        <label for="email">Email: </label>
        <input type="text" name="email" id="email">
        <label for="password">Password: </label>
        <input type="password" name="password" id="password">
        <input type="submit" name="signin" value="Sign in!">
    </form>
    <a class="button" href="${pageContext.request.contextPath}/views/registration.jsp">Sign up</a>
</div>
<%--<h1>Huli ono ne rabotaet?</h1>--%>
<%--<h2>Сегодня: <%= new Date() %></h2>--%>
</body>
</html>
