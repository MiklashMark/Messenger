package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Credentials;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.SignInException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IUserDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserSignInService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.MessageServiceFactory;

import java.util.List;

public class UserSignInService implements IUserSignInService {
    private IUserDao userDao;
    private IMessageService messageService = MessageServiceFactory.getInstance();

    private User user;

    public UserSignInService(IUserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User getUser() {
        return user;
    }

    @Override
    public boolean signIn(Credentials credentials) throws SignInException {
        if (credentials.getLogin() == null || credentials.getPassword() == null) {
            throw new IllegalArgumentException("Credentials not entered! Try again.");
        }
        return isCorrectLogin(credentials) && isCorrectPassword(credentials);
    }

    @Override
    public boolean isCorrectLogin(Credentials credentials) throws SignInException {
        List<User> list = userDao.getUsers();

        for (User u : list) {
            if (u.getLogin().equals(credentials.getLogin())) {
                user = u;
                return true;
            }
        }
        throw new SignInException("There's no users with this login! Try again.");
    }

    @Override
    public boolean isCorrectPassword(Credentials credentials) throws SignInException {
        if (user.getPassword().equals(credentials.getPassword())) {
            return true;
        };
        throw new SignInException("Incorrect password! Try again.");
    }

    @Override
    public List<Message> getUserMessages(User user) {
       return messageService.getUserMessages(user);
    }
}