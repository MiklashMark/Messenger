<%@ page language="java"
contentType="text/html; charset-UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Register</title>
    </head>

    <body>
        <div class="form">
            <h1>Welcome! Register an account</h1>
            <form action="${pageContext.request.contextPath}/api/user" method="POST">
                <fieldset>
                    <legend>Personal information</legend>
                    <div> <input class="form-input" type="text" name="firstName" placeholder="Your first name"> </div>
                    <div> <input class="form-input" type="text" name="lastName" placeholder="Your last name"> </div>
                    <div> <input class="form-input" type="text" name="birthDay" placeholder="Date of Birth"> </div>
                    *Use the format dd.MM.yyyy.
                    **Age must be greater than or equal to 12 years.
                </fieldset>

                <fieldset>
                    <legend>Login and password</legend>
                    <div> <input class="form-input" type="text" name="login" placeholder="Login"> </div>
                    *Your login length must be between 6 and 32 characters.
                    **Whitespace characters are not allowed.
                    <div> <input class="form-input" type="password" name="password" placeholder="Desired password"> </div>
                    *The minimum password length is 8 characters, and the maximum is 32.
                    **Password must contain at least one Russian/English letter, special symbol, and digit.
                </fieldset>

                <button type="submit">Sign Up</button>
                <button type="reset">Clear</button>
            </form>
        </div>
    </body>
</html>
