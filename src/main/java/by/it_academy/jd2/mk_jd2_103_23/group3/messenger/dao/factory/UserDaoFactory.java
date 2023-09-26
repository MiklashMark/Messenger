package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.UserDao;

public class UserDaoFactory {
    private volatile static UserDao instance;

    private UserDaoFactory() {
    }

    public static UserDao getInstance() {
        if (instance == null) {
            synchronized (UserDaoFactory.class) {
                if (instance == null) {
                    instance = new UserDao();
                }
            }
        }
        return instance;
    }
}
