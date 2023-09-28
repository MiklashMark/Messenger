<%@ page language="java"
         contentType="text/html; charset-UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Входящие</title>
</head>

<body>
<h1>Входящие</h1>
<form action="${pageContext.request.contextPath}/ui/users/message.jsp" method="POST">
    <p><button type="submit">Написать сообщение</button></p>
</form>
</body>
</html>