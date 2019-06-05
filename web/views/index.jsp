<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
</head>
<body>
<header class="header">
    <%--<jsp:include page="_menu.jsp"></jsp:include>--%>
    <menu type="toolbar">
        <a href="${pageContext.request.contextPath}/">Home</a>
        <%--<a href="${pageContext.request.contextPath}/menu">Menu</a>--%>
        <%--<a href="${pageContext.request.contextPath}/userInfo">User Info</a>--%>
        <c:choose>
            <c:when test="${loginedUser.userName}!=null">
                <%--<a href="${pageContext.request.contextPath}/logout">Logout</a>--%>
                <span style="color:red">[ ${loginedUser.userName} ]</span>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/login">Login</a>
                <a href="${pageContext.request.contextPath}/registration">Registration</a>
                <span style="color:red">[ Unregistered user ]</span>
            </c:otherwise>
        </c:choose>
    </menu>
</header>
<div class="body">
    <h2>This is Main Page</h2>
</div>
</body>
</html>