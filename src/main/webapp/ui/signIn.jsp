<%@ page language="java"
         contentType="text/html; charset-UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>Авторизация</title>
</head>

<body>
<h1>Авторизация</h1>
<form action="${pageContext.request.contextPath}/api/login" method="POST">
    <fieldset>
        <legend>Логин и пароль</legend>
        <div> <input class="form-input" type="text" name="login"
                     placeholder="Введите логин"> </div>
        <div> <input class="form-input" type="password" name="password"
                     placeholder="Введите пароль"> </div>
    </fieldset>
    <p><button type="submit">Войти</button>
        <button type="reset">Очистить</button></p>
    <a href="${pageContext.request.contextPath}/api/user">Создайте аккаунт, это легко</a>
</form>
</body>
</html>