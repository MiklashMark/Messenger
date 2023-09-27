
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.MessageException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IMessageDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDao implements IMessageDao {
    private Map<User, List<Message>> usersMessages = new HashMap<>();

    @Override
    public void addMessage(String login, Message message) throws MessageException {
        User searchedUser = usersMessages.keySet().stream()
                .filter(entry -> entry.getLogin().equals(login))
                .findFirst()
                .orElseThrow(() -> new MessageException("There's no users with this login! try again."));

        usersMessages.computeIfPresent(searchedUser, (u, messageList) -> {
            messageList.add(message);
            return messageList;
        });
    }

    @Override
    public Map<User, List<Message>> getUsersMessages() {
        return usersMessages;
    }
}
