package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets.ui;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UiSignUpServlet", urlPatterns = "/ui/signUp")
public class UiSignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/signUp.jsp").forward(req, resp);
    }
}
