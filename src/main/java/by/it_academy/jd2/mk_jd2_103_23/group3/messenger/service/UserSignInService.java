package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.UserDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IUserDao;

public class UserSignInService {
    IUserDao userDao;
    public UserSignInService(IUserDao userDao) {
        this.userDao = userDao;
    }
}
