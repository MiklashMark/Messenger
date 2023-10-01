
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;

import java.util.List;
import java.util.Map;

public interface IMessageService {
    void sendMessage(String login, String message, User user) throws MessageException;
    Map<User, List<Message>> getMessages();
    List<Message> getUserMessages(User user);
    void addRegisteredUser(User user);

    long getCount();
}
