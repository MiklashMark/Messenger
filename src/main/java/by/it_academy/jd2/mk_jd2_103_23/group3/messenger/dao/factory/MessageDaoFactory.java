
package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.MessageDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.data_source.DBDataSource;

public class MessageDaoFactory {
    private volatile static MessageDao instance;

    private MessageDaoFactory() {
    }

    public static MessageDao getInstance() {
        if (instance == null) {
            synchronized (MessageDaoFactory.class) {
                if (instance == null) {
                    instance = new MessageDao(DBDataSource.getInstance());
                }
            }
        }
        return instance;
    }
}
