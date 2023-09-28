package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Сервлет главной страницы
 */

@WebServlet (urlPatterns = "/api")
public class HomePageServlet extends HttpServlet {
    private static final String SIGN_IN_PARAM_NAME = "signIn";
    private static final String SIGN_UP_PARAM_NAME = "signUp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ui/homePage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(SIGN_UP_PARAM_NAME) != null) {
            resp.sendRedirect(req.getContextPath() + "/api/user");
        }

        if (req.getParameter(SIGN_IN_PARAM_NAME) != null) {
            resp.sendRedirect(req.getContextPath() + "/api/login");
        }
    }
}
