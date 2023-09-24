package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.ValidationException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IUserDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserRegistrationService;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserRegistrationService implements IUserRegistrationService {
    private IUserDao userDao;

    public UserRegistrationService(IUserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void save(User user) throws ValidationException {
            if (user == null) {
                throw new IllegalArgumentException("The data for registration wasn't entered!");
            }

            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String login = user.getLogin();
            String password = user.getPassword();
            String birthDay = user.getBirthDay();

            validateNameLanguage(firstName, lastName);
            validateNameCapitalization(firstName, lastName);
            validateUniqueLogin(login);
            validateLoginLength(login);
            validateLoginNoSpace(login);
            validatePasswordLength(password);
            validatePasswordComplexity(password);
            validateBirthDate(birthDay);

            userDao.save(user);
        }

        private void validateNameLanguage (String firstName, String lastName) throws ValidationException {
            if (!firstName.matches(".*[а-яА-Я].*") && !lastName.matches(".*[а-яА-Я].*")) {
                if (firstName.matches(".*[a-zA-Z].*") || lastName.matches(".*[a-zA-Z].*")) {
                    throw new ValidationException("First and last names should be written in one language!");
                }
            }
        }

        private void validateNameCapitalization (String firstName, String lastName) throws ValidationException {
            if (!firstName.matches(".*[A-Z].*") || !lastName.matches(".*[A-Z].*")) {
                throw new ValidationException("Field NAME is incorrect. Please, enter the name with a capital letter.");
            }
        }

        private void validateUniqueLogin (String login) throws ValidationException {
            if (login.equals(getUser().getLogin())) {
                throw new ValidationException("Login is already taken. Please, change login.");
            }
        }

        private void validateLoginLength (String login) throws ValidationException {
            if (login.length() < 6 || login.length() > 32) {
                throw new ValidationException("Incorrect login length! Your login length must be between 6 and 32 characters.");
            }
        }

        private void validateLoginNoSpace (String login) throws ValidationException {
            if (login.contains(" ")) {
                throw new ValidationException("Remove space symbol from the login!");
            }
        }

        private void validatePasswordLength (String password) throws ValidationException {
            if (password.length() < 8 || password.length() > 32) {
                throw new ValidationException("Password is too short! The minimum password length is 8 characters, and the maximum is 32.");
            }
        }

        private void validatePasswordComplexity (String password) throws ValidationException {
            if (!password.matches("^(?=.*[!@#$%^&*()_+=\\[\\]{};:'\",<.>/?a-zA-Zа-яА-Я])(?=.*\\d).*$")) {
                throw new ValidationException("Password must contain at least one Russian/English letter, special symbol, and digit.");
            }
        }
    public void validateBirthDate(String birthDate) throws ValidationException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);

        if (age.getYears() < 12) {
            throw new ValidationException("Age must be greater than or equal to 12 years.");
        }
}
@Override
    public User getUser() {
        return null;
//        return this.userDao.getUsers;
    }
}
