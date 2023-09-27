
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets;


import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "api/message")
public class MessageServlet extends HttpServlet {
    private static final String TEXT_NAME = "text";



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("user");


        PrintWriter writer = resp.getWriter();
        writer.write("<p>" + currentUser + "</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

