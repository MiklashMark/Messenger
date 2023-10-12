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

        <p>Incoming messages for
            <c:out value="${user.getLogin()}"/></br>

            <c:forEach items="${requestScope.chat}"
                       var="message">
                <tr>
                    <td width="20%">${message.from}</td>
                    <td width="20%">${message.sendDate}</td>
                    <td width="60%"><c:out value="${message.text}" escapeXml="true"/></td>
                </tr>
            </c:forEach>
        </p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/';" value="Home page" /></p>
    </form>
    </body>
</html>