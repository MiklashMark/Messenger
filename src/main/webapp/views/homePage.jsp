<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Home page</title>
</head>

<body>
<h1>Home page</h1>
<c:choose>
    <c:when test="${sessionScope.user == null}">
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp';" value="Sign Up" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signIn';" value="Sign In" /></p>
    </c:when>
    <c:otherwise>
        <c:if test="${user.isAdministrator()}">
            <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistics';" value="View server statistics" /></p>
        </c:if>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/chats';" value="Incoming messages" /></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/message';" value="Write message" /></p>
    </c:otherwise>
</c:choose>
</body>
</html>
