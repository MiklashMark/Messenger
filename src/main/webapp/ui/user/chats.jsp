<%@ page language="java"
         contentType="text/html; charset-UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Incoming messages</title>
</head>

<body>
<h1>Incoming messages</h1>
<form action="${pageContext.request.contextPath}/ui/users/message.jsp" method="POST">
    <p><button type="submit">Write a message</button></p>
</form>
</body>
</html>