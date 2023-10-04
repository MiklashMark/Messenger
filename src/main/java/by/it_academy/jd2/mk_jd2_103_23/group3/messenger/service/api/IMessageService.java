
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;

import java.util.List;
import java.util.Map;

public interface IMessageService {

    /**
     * Add message in Message List to user to whom we send;
     * @param login
     * @param message
     * @param user
     * @throws MessageException
     */
    void sendMessage(String login, String message, User user) throws MessageException;
    Map<User, List<Message>> getMessages();

    /**
     * Get all messages of current user;
     * @param user
     * @return
     */
    List<Message> getUserMessages(User user);

    /**
     * Add registered user in MessageDao;
     * @param user
     */
    void addRegisteredUser(User user);

    /**
     * Get total count of messages;
     * @return
     */
    long getCount();
}
