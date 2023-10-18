package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.filters;


import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Filter is used for limit access to admin pages
 * Checking "user" attribute and isAdministrator flag;
 */
@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();

        if ((session != null) && (session.getAttribute("user") != null)) {
            User user = (User) session.getAttribute("user");
            if (user.isAdministrator()) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            // редирект на логин
            resp.sendRedirect(contextPath + "/");
        }
    }
}
