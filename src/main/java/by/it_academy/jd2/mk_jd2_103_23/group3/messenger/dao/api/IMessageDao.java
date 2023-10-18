
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api;


import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;

import java.util.List;
import java.util.Map;

public interface IMessageDao {
    /**
     * Adding message in MessageDao with user existence check;
     * @param login
     * @param message
     * @throws MessageException
     */
    void addMessage(String login, Message message) throws MessageException;
    Map<User, List<Message>> getUsersMessages();

    /**
     * Returns Message list for current user;
     * @param user
     * @return
     */
    List<Message> getUserMessages(User user);

    /**
     * Adds registered user in MessageDao;
     * @param user
     */
    void addUser( User user);

    /**
     * Returns total count of messages;
     * @return
     */
    long getCount();
}

