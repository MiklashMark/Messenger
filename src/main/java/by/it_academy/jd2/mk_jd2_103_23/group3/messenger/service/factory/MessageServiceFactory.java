
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory.MessageDaoFactory;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.MessageService;

public class MessageServiceFactory {
    private volatile static MessageService instance;

    private MessageServiceFactory(){

    }

    public static MessageService getInstance() {
        if (instance == null) {
            synchronized (MessageServiceFactory.class) {
                if (instance == null) {
                    instance = new MessageService(MessageDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
