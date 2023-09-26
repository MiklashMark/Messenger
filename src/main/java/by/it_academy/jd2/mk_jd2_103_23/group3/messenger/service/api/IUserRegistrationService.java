package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.ValidationException;

import java.util.List;

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
    List<User> getUser();

    void validateNameLanguage(String firstName, String lastName) throws ValidationException;
    void validateNameCapitalization(String firstName, String lastName) throws ValidationException;
    void validateUniqueLogin(String login, User user) throws ValidationException;
    void validateLoginLength(String login) throws ValidationException;
    void validateLoginNoSpace(String login) throws ValidationException;
    void validatePasswordLength(String password) throws ValidationException;
    void validatePasswordComplexity(String password) throws ValidationException;
    void validateFormatBirthDate(String birthDay) throws ValidationException;
    void validateBirthDate(String birthDate) throws ValidationException;
}
