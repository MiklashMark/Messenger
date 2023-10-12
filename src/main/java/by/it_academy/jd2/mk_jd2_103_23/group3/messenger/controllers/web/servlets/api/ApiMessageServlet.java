package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.servlets.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n.MessageCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.MessageServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


/**
 * Servlet is used for sending messages;
 */
@WebServlet(urlPatterns = "/api/message")
public class ApiMessageServlet extends HttpServlet {
    private static final String TEXT_PARAM_NAME = "message";
    private static final String USER_PARAM_NAME = "login";

    private IMessageService messageService = MessageServiceFactory.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String text = req.getParameter(TEXT_PARAM_NAME);
        String recipient = req.getParameter(USER_PARAM_NAME);

        User currentUser = (User) session.getAttribute("user");
        if(currentUser == null){
            throw new SecurityException("Ошибка безопасности");
        }

        MessageCreateDTO message = new MessageCreateDTO();
        message.setFrom(currentUser.getLogin());
        message.setTo(recipient);
        message.setText(text);

        try{
            this.messageService.sendMessage(message);
            req.setAttribute("success", true);
        } catch (IllegalArgumentException | MessageException e){
            req.setAttribute("error", true);
            req.setAttribute("message",  e.getMessage());
        }

        req.getRequestDispatcher("/views/message.jsp").forward(req, resp);
    }
}




    