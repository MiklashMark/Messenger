package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.UserLoginDTO;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.SignInException;

import java.util.List;

public interface IUserSignInService {

    User getUser();

    // handle users SignIn;
    // return true if user successfully signIn;
    boolean signIn(UserLoginDTO credentials) throws SignInException;
    boolean isCorrectLogin(UserLoginDTO credentials) throws SignInException;
    boolean isCorrectPassword(UserLoginDTO credentials) throws SignInException;
    List<Message> getUserMessages(User user);
}