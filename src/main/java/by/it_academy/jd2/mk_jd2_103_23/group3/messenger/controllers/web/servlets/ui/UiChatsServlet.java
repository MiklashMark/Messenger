package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets.ui;


import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * Is used for set attribute with messages and dispatch in jsp;
 */
@WebServlet("/ui/user/chats")
public class UiChatsServlet extends HttpServlet {
    IMessageService messageService = MessageServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Message> messages = messageService.getUserMessages(user);
        messages.forEach(System.out::println);
        req.setAttribute("chat", messages);
        req.getRequestDispatcher("/views/chats.jsp").forward(req, resp);
    }
}
