package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Credentials;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.SignInException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserSignInService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.UserSignInFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet is used for obtain users credentials,
 * authorize user and handle users signIn;
 * */
@WebServlet(urlPatterns = "/api/login")
public class ApiLoginServlet extends HttpServlet {
    private final static String LOGIN_PARAM_NAME = "login";
    private final static String PASSWORD_PARAM_NAME = "password";

    private IUserSignInService userSignInService = UserSignInFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ui/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter(LOGIN_PARAM_NAME);
        String password = req.getParameter(PASSWORD_PARAM_NAME);

        Credentials credentials = new Credentials(login,password);

        try {
            if(userSignInService.signIn(credentials)) {
                User user = userSignInService.getUser();
                if (user.isAdministrator()) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    req.getRequestDispatcher("/ui/admin/statistics.jsp").forward(req, resp);
                }
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setAttribute("messages", userSignInService.getUserMessages(user));
                req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);
            }
        } catch (IllegalArgumentException e) {
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        } catch (SignInException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }
    }
}