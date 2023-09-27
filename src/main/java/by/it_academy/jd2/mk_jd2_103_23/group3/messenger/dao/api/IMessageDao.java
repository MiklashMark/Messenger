
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api;


import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;

import java.util.List;

public interface IMessageDao {
    void addMessage(String login, String message);
    List<Message> getMessages();
}

