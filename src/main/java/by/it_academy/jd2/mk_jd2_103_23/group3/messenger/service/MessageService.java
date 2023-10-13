
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n.MessageCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IMessageDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;

import java.time.LocalDateTime;
import java.util.List;

public class MessageService implements IMessageService {
    private final IMessageDao messageDao;

    public MessageService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }


    @Override
    public void sendMessage(MessageCreateDTO message) throws MessageException {
        if (message.getText().isEmpty()) {
            throw new IllegalArgumentException("Text not entered! Please, enter the text.");
        }
        if (message.getText().length() > 150) {
            throw new IllegalArgumentException("The text is too long!");
        }

        Message entity = new Message();
        entity.setMessage(message.getText());
        entity.setFrom(message.getFrom());
        entity.setTo(message.getTo());
        entity.setTime(LocalDateTime.now());

        messageDao.addMessage(entity.getTo(), entity);
    }

    @Override
    public long getCount(){
        return this.messageDao.getCount();
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
