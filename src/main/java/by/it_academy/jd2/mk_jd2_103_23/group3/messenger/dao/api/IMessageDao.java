
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api;


import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;

import java.util.List;
import java.util.Map;

public interface IMessageDao {
    void addMessage(String login, Message message) throws MessageException;
    Map<User, List<Message>> getUsersMessages();
    void addUser( User user);
}

