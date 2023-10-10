package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n.UserCreateDTO;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.exceptions.ValidationException;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IUserDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserRegistrationService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.MessageServiceFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserRegistrationService implements IUserRegistrationService {
    private IUserDao userDao;
    private IMessageService messageService = MessageServiceFactory.getInstance();

    public UserRegistrationService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUser() {
        return this.userDao.getUsers();
    }

    @Override
    public long getCount() {
        return this.userDao.getUsers().size();
    }

    @Override
    public void save(UserCreateDTO user) throws ValidationException {
        if (user == null) {
            throw new IllegalArgumentException("The data for registration wasn't entered!");
        }
        User entity = new User();

        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setBirthDay(user.getBirthday());
        entity.setRegistrationDate(LocalDateTime.now());
        entity.setAdministrator(false);

        validateNameLanguage(user.getFirstName(), user.getLastName());
        validateNameCapitalization(user.getFirstName(), user.getLastName());
        validateUniqueLogin(user.getLogin(), entity);
        validateLoginLength(user.getLogin());
        validateLoginNoSpace(user.getLogin());
        validatePasswordLength(user.getPassword());
        validatePasswordComplexity(user.getPassword());
        validateFormatBirthDate(user.getBirthday());
        validateBirthDate(user.getBirthday());

        messageService.addRegisteredUser(entity);
        userDao.save(entity);

    }



    @Override
    public void validateNameLanguage(String firstName, String lastName) throws ValidationException {
        if (!firstName.matches(".*[а-яА-Я].*") && !lastName.matches(".*[а-яА-Я].*")) {
            if (!firstName.matches(".*[a-zA-Z].*") && !lastName.matches(".*[a-zA-Z].*")) {
                throw new ValidationException("First and last names should be written in one language!");
            }
        }
    }

    @Override
    public void validateNameCapitalization(String firstName, String lastName) throws ValidationException {
        if (!Character.isUpperCase(firstName.charAt(0)) || !Character.isUpperCase(lastName.charAt(0))) {
            throw new ValidationException("Field NAME is incorrect. Please, enter the name with a capital letter.");
        }
    }

    @Override
    public void validateUniqueLogin(String login, User user) throws ValidationException {
        if (getUser().contains(user)) {
            throw new ValidationException("Login is already taken. Please, change login.");
        }
    }

    @Override
    public void validateLoginLength(String login) throws ValidationException {
        if (login.length() < 6 || login.length() > 32) {
            throw new ValidationException("Incorrect login length! Your login length must be between 6 and 32 characters.");
        }
    }

    @Override
    public void validateLoginNoSpace(String login) throws ValidationException {
        if (login.contains(" ")) {
            throw new ValidationException("Remove space symbol from the login!");
        }
    }

    @Override
    public void validatePasswordLength(String password) throws ValidationException {
        if (password.length() < 8 || password.length() > 32) {
            throw new ValidationException("Password is too short! The minimum password length is 8 characters, and the maximum is 32.");
        }
    }

    @Override
    public void validatePasswordComplexity(String password) throws ValidationException {
        if (!password.matches("^(?=.*[!@#$%^&*()_+=\\[\\]{};:'\",<.>/?a-zA-Zа-яА-Я])(?=.*\\d).*$")) {
            throw new ValidationException("Password must contain at least one Russian/English letter, special symbol, and digit.");
        }
    }
    @Override
    public void validateFormatBirthDate(String birthDay) throws ValidationException {
        String datePattern = "\\d{2}.\\d{2}.\\d{4}";

        if (!birthDay.matches(datePattern)) {
            throw new ValidationException("Invalid date format. Please use the format dd.MM.yyyy.");
        }
    }
    @Override
    public void validateBirthDate(String birthDate) throws ValidationException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateOfBirth = LocalDate.parse(birthDate, formatter);

        LocalDate currentDate = LocalDate.now();
        Period age = Period.between(dateOfBirth, currentDate);

        if (age.getYears() < 12) {
            throw new ValidationException("Age must be greater than or equal to 12 years.");
        }
    }
}
