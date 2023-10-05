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
        <form action="${pageContext.request.contextPath}/api" method="POST">
<%--        <button type="submit" name="signIn">Sign In</button><br>--%>
            <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signIn';" value="Sign In" /></p>
            <label>Log in to your account</label><br><br>
<%--        <button type="submit" name="signUp">Sign Up</button><br>--%>
            <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/signUp';" value="Sign Up" /></p>
            <label>Don't have an account?</label>

        </form>
    </body>
</html>