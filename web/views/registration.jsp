<%--
  Created by IntelliJ IDEA.
  User: rex
  Date: 5/27/2019
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
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
        <input type="submit" name="signin" value="Sign up!">
    </form>
    <a class="button" href="${pageContext.request.contextPath}/views/login.jsp">Sign in</a>
</div>
</body>
</html>
