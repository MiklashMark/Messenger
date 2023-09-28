
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets;


import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.ValidationException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private static final String TEXT_PARAM_NAME = "message";
    private static final String USER_PARAM_NAME = "login";

    private IMessageService messageService = MessageServiceFactory.getInstance();
    private HttpSession session;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        User user = (User)session.getAttribute("user");
        messageService.getUserMessages(user);
    }
  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/ui/user/chats.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter(TEXT_PARAM_NAME);
        String user = req.getParameter(USER_PARAM_NAME);

        session = req.getSession();
        User currentUser = (User) session.getAttribute("user");

        try {
            messageService.sendMessage(user, message, currentUser);
        } catch (IllegalArgumentException e) {
            resp.setStatus(500);
            resp.getWriter().write(e.getMessage());
        } catch (MessageException e) {
            resp.setStatus(400);
            resp.getWriter().write(e.getMessage());
        }
    }
}




    