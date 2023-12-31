package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.UserCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.ValidationException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserRegistrationService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.UserRegistrationFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * Servlet is used to handle users SignUp;
 */
@WebServlet(urlPatterns = "/api/user")
public class ApiUserServlet extends HttpServlet {

    private static final String LOGIN_NAME = "login";
    private static final String PASSWORD_NAME = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String BIRTH_DAY = "birthDay";

    private IUserRegistrationService userRegistrationService = UserRegistrationFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN_NAME);
        String password = req.getParameter(PASSWORD_NAME);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String birthDay = req.getParameter(BIRTH_DAY);

        UserCreateDTO user = new UserCreateDTO();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        if (!birthDay.isBlank()) {
            user.setBirthday(birthDay);
        }

        try {
            userRegistrationService.save(user);
            req.getRequestDispatcher("/views/signIn.jsp").forward(req, resp);
        } catch (ValidationException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }
    }
}



