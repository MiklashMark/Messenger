package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.listeners.UserListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (urlPatterns = "/api/admin/statistics")
public class StatisticsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int countActiveUser = UserListener.getActiveUsers();
        PrintWriter writer = resp.getWriter();
        writer.write("<p> Количесто " + countActiveUser + "</p>");
    }
}
