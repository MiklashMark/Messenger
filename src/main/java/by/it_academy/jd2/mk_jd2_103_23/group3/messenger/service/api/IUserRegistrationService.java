package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.ValidationException;

public interface IUserRegistrationService {
    /**
     * User registration validation;
     * @param user
     */
    void save(User user) throws ValidationException;

    /**
     * Getting userList;
     * @return
     */
    User getUser();
}
