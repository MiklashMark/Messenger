<%@ page language="java"
contentType="text/html; charset-UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Главная страница</title>
    </head>
    <body>
        <h1>Главная страница</h1>
        <form action="${pageContext.request.contextPath}/api" method="POST">
        <button type="submit" name="signIn">Вход</button><br>
        <label>Войдите, если у Вас уже есть логин и пароль</label><br><br>
        <button type="submit" name="signUp">Регистрация</button><br>
        <label>Нажмите, если вы хотите зарегистрироваться</label>
        </form>
    </body>
</html>