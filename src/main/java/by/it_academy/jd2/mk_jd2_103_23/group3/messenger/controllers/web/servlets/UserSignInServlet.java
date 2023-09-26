package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserSignInService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.UserRegistrationFactory;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.UserSignInFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserSignInServlet extends HttpServlet {
    private final static String LOGIN_PARAM_NAME = "login";
    private final static String PASSWORD_PARAM_NAME = "password";

    private IUserSignInService userSignInService = UserSignInFactory.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM_NAME);

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
    }
}
