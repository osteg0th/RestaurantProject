<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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