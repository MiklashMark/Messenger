<%@ page language="java"
contentType="text/html; charset-UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Регистрация</title>
    </head>

    <body>
        <div class="form">
            <h1>Регистрация</h1>
            <form action="${pageContext.request.contextPath}/api/user" method="POST">
                <fieldset>
                    <legend>Контактная информация</legend>
                    <div> <input class="form-input" type="text" name="firstName" placeholder="Ваше имя"> </div>
                    <div> <input class="form-input" type="text" name="lastName" placeholder="Ваша фамилия"> </div>
                    <div> <input class="form-input" type="text" name="birthDay" placeholder="Дата рождения"> </div>
                </fieldset>

                <fieldset>
                    <legend>Логин и пароль</legend>
                    <div> <input class="form-input" type="text" name="login" placeholder="Ваш логин"> </div>
                    <div> <input class="form-input" type="password" name="password" placeholder="Придумайте пароль"> </div>
                </fieldset>

                <button type="submit">Зарегистрироваться</button>
                <button type="reset">Очистить</button>
            </form>
        </div>
    </body>
</html>
