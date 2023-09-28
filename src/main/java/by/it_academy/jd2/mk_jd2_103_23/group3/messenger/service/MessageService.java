
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IMessageDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class MessageService implements IMessageService {
    private IMessageDao messageDao;

    public MessageService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }


    @Override
    public void sendMessage(String login, String text, User user) throws MessageException {
        if (text.isEmpty()) {
            throw new IllegalArgumentException("Text not entered! Please, enter the text.");
        }
        if (text.length() > 150) {
            throw new MessageException("The text is too long!");
        }

        Message message = new Message();
        message.setMessage(text);
        message.setFrom(user.getLogin());
        message.setTo(login);
        message.setTime(LocalDateTime.now());

        messageDao.addMessage(login, message);
    }

    @Override
    public Map<User, List<Message>> getMessages() {
       return messageDao.getUsersMessages();
    }

    @Override
    public List<Message> getUserMessages(User user) {
       return messageDao.getUserMessages(user);
    }

    @Override
    public void addRegisteredUser(User user) {
        messageDao.addUser(user);
    }
}
