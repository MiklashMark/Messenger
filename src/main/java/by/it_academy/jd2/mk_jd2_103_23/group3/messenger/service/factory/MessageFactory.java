
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory.MessageDaoFactory;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.MessageService;

public class MessageFactory {
    private volatile static MessageService instance;

    private MessageFactory(){

    }

    public static MessageService getInstance() {
        if (instance == null) {
            synchronized (MessageFactory.class) {
                if (instance == null) {
                    instance = new MessageService(MessageDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
