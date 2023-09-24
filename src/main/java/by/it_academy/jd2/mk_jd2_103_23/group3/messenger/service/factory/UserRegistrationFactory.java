package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory.UserDaoFactory;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.UserRegistrationService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserRegistrationService;

public class UserRegistrationFactory {
    private volatile static UserRegistrationService instance;


    private UserRegistrationFactory() {
    }

    public IUserRegistrationService getInstance() {
        if (instance == null) {
            synchronized (UserRegistrationFactory.class) {
                if (instance == null) {
                    instance = new UserRegistrationService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
