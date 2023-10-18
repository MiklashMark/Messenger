package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.UserCreateDTO;

import java.time.LocalDate;
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

    public void validationForSignUp(UserCreateDTO user);



    /**
     * Returns total count of registered users;
     * @return
     */
    long getCount();

    LocalDate setLocalDateTimeFromString(String strDate);
}
