package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IUserDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserSignInService;

import java.util.List;

public class UserSignInService implements IUserSignInService {
    private IUserDao userDao;

    private User user;

    public UserSignInService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean isRightLogin(User user) {
        boolean isPresent = false;
        List<User> list = userDao.getUsers();
        for (User u : list) {
            if (u.getLogin().equals(user.getLogin())) {
                isPresent = true;
                this.user = u;
            }
        }
        return isPresent;
    }

    @Override
    public boolean isRightPassword(User user) {
        boolean isPresent = false;
        if (this.user.getPassword().equals(user.getPassword())) {
            isPresent = true;
        }
        return isPresent;
    }
}