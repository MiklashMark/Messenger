<%@ page language="java"
         contentType="text/html; charset-UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Write a message</title>
</head>

<body>
    <c:choose>
        <c:when test="${requestScope.success}">
                <p style="color:green;">Message sent successfully</p>
        </c:when>
        <c:when test="${requestScope.error}">
                <p style="color:red;">${requestScope.message}</p>
        </c:when>
    </c:choose>

    <div class="form">
        <h1>Write a message</h1>
        <form action="${pageContext.request.contextPath}/api/message" method="POST">
            <label>To:</label><br>
            <div> <input class="form-input" type="text" name="login"
                         placeholder="Login (to)"> </div><br>
            <label>Text:</label><br>
            <div> <textarea class="form-textarea" name="message"
                            placeholder="Write a message"></textarea></div>

            <button type="submit">Send</button>
            <button type="reset">Clear</button>
        </form>
    </div>

    </p><input type="button" onclick="location.href='${pageContext.request.contextPath}/ui/user/message';"
    value="Back to incoming messages"/></p>
        </br></br>
            <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/';" value="index" /></p>

</body>
</html>