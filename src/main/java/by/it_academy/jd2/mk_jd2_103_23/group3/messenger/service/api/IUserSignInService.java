package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;

public interface IUserSignInService {
    boolean isRightLogin(User user);
    boolean isRightPassword(User user);
}