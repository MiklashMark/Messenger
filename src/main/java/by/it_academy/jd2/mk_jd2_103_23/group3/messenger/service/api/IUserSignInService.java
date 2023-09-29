package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Credentials;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.SignInException;

import java.util.List;

public interface IUserSignInService {

    User getUser();

    boolean signIn(Credentials credentials) throws SignInException;
    boolean isCorrectLogin(Credentials credentials) throws SignInException;
    boolean isCorrectPassword(Credentials credentials) throws SignInException;
    List<Message> getUserMessages(User user);
}