<%@ page language="java"
contentType="text/html; charset-UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
         <form action="${pageContext.request.contextPath}/api" method="POST">
         <button type="submit" name="signIn">Sign In</button><br>
         <label>Log in to your account</label><br><br>
         <button type="submit" name="signUp">Sign Up</button><br>
         <label>Don't have an account?</label>
         </form>
    </c:when>
    <c:otherwise>
    <c:if test="${user.isAdministrator()}">
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/admin/statistics.jsp';"
                  value="View server statistics"/></p>
    </c:if>
        </p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/message';"
        value="Incoming messages"/></p>
        </p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/message.jsp';"
        value="Write message"/></p>
    </c:otherwise>
    </c:choose>
</body>
</html>