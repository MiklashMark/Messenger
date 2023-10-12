package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets.ui.admin;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.StatisticsService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IStsatisticService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


/**
 * Admin servlet. Is used for setting stats attribute and dispatch req on jsp;
 */
@WebServlet (name = "StatisticsServlet" , urlPatterns = "/ui/admin/statistics")    // ui/admin/statistics
public class StatisticsServlet extends HttpServlet {

    private final IStsatisticService statisticsService;

    public StatisticsServlet() {
        this.statisticsService = StatisticsService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("stats", statisticsService.getStats());

        req.getRequestDispatcher("ui/admin/statistics.jsp").forward(req, resp);

    }
}