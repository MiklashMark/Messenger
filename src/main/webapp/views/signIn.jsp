<%@ page language="java"
         contentType="text/html; charset-UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Log in to your account</title>
</head>

<body>
<h1>Log in to your account</h1>
<form action="${pageContext.request.contextPath}/api/login" method="POST">
    <fieldset>
        <legend>Login and password</legend>
        <div> <input class="form-input" type="text" name="login"
                     placeholder="Enter your login"> </div>
        <div> <input class="form-input" type="password" name="password"
                     placeholder="Enter your password"> </div>
    </fieldset>
    <p><button type="submit">Sign In</button>
        <button type="reset">Clear</button></p>
</form>
</body>
</html>