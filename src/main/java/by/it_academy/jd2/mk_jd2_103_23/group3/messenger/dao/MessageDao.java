
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.List;

public class MessageDao implements IMessageDao {
    private final List <Message> messages = new ArrayList<>();


    @Override
    public void save(Message message) {
        synchronized (messages){
            messages.add(message);
        }

    }

    @Override
    public List<Message> getMessage() {
        return messages;
    }
