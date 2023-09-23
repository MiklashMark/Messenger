package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.html;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet
public class UserRegistrationServlet extends HttpServlet {

    private static final String LOGIN_NAVE = "login";
    private static final String PASSWORD_NAME = "password";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    //Service service = new Service;

    /*private static final String BIRTH_DAY = "birthDay";
    private static final String REGISTRATION_DATE = "registr";
    private static final boolean IS_ADMINISTRATION = false;
*/


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        String login = req.getParameter(LOGIN_NAVE);
        String password = req.getParameter(PASSWORD_NAME);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        /*try {
            service.save(user);
        } catch (IllegalArgumentException e){
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        }*/
    }
}



