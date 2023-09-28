<%@ page language="java"
         contentType="text/html; charset-UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Форма для отправки сообщения</title>
</head>

<body>
<div class="form">
    <h1>Написать сообщение</h1>
    <form action="${pageContext.request.contextPath}/api/message" method="POST">
        <label>Кому:</label><br>
        <div> <input class="form-input" type="text" name="login"
                     placeholder="Логин адресата"> </div><br>
        <label>Текст:</label><br>
        <div> <textarea class="form-textarea" name="text"
                        placeholder="Введите сообщение"></textarea></div>

        <button type="submit">Отправить</button>
        <button type="reset">Очистить</button>
    </form>
</div>
</body>
</html>