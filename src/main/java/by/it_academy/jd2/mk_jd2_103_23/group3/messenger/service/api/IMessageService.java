
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n.MessageCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;

import java.util.List;

public interface IMessageService {

    // Add object message to chatStorage;
    void sendMessage(MessageCreateDTO message) throws MessageException;

    // Get all messages of current user;
    List<Message> getUserMessages(User user);

    // Add registered user in MessageDao;
    void addRegisteredUser(User user);

    //Get total count of messages;
    long getCount();
}
