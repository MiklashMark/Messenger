
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.MessageDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IMessageDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;

import java.util.List;

public class MessageService implements IMessageService {
    private IMessageDao messageDao;

    public MessageService(IMessageDao messageDao) {
        this.messageDao = messageDao;
    }


    @Override
    public void sendMessage(String login, String message) {

    }

    @Override
    public void getMessages(List<Message> messages) {

    }
}
