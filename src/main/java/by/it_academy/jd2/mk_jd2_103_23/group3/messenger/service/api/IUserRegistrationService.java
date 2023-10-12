package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n.UserCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.ValidationException;

import java.util.List;

public interface IUserRegistrationService {
    /**
     * User registration validation;
     * @param user
     */
    void save(UserCreateDTO user);

    /**
     * Getting userList;
     * @return
     */
    List<User> getUser();


    /**
     * Returns total count of registered users;
     * @return
     */
    long getCount();

}
