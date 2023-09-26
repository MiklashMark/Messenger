package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory.UserDaoFactory;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.UserRegistrationService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.UserSignInService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserRegistrationService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserSignInService;

public class UserSignInFactory {
    private volatile static UserSignInService instance;


    private UserSignInFactory() {
    }

    public static IUserSignInService getInstance() {
        if (instance == null) {
            synchronized (UserSignInFactory.class) {
                if (instance == null) {
                    instance = new UserSignInService(UserDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
