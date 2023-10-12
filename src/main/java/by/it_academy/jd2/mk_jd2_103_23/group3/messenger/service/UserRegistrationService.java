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
import java.util.ArrayList;
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
    public void save(UserCreateDTO user) throws IllegalArgumentException {
        validationForSignUp(user);

        User entity = new User();

        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setBirthDay(user.getBirthday());
        entity.setRegistrationDate(LocalDateTime.now());
        entity.setAdministrator(false);


        messageService.addRegisteredUser(entity);
        userDao.save(entity);

    }

    private void validationForSignUp(UserCreateDTO user) throws ValidationException {
        if (user == null) {
            throw new ValidationException("Please fill in all registration fields");
        }

        List<String> errorsMessages = new ArrayList<>();

        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String login = user.getLogin();
        String password = user.getPassword();
        String birthDay = user.getBirthday();

        if (!firstName.matches(".*[а-яА-Я].*") && !lastName.matches(".*[а-яА-Я].*")) {
            if (!firstName.matches(".*[a-zA-Z].*") && !lastName.matches(".*[a-zA-Z].*")) {
                errorsMessages.add("First and last names should be written in one language!");
            }
        }

        if (firstName.isBlank() || lastName.isBlank()) {
            errorsMessages.add("Field NAME is incorrect. Please, enter the name with a capital letter.");
        } else if (!Character.isUpperCase(firstName.charAt(0)) || !Character.isUpperCase(lastName.charAt(0))) {
            errorsMessages.add("Field NAME is incorrect. Please, enter the name with a capital letter.");
        }


        for (User userTemp : getUser()) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                errorsMessages.add("Login is already taken. Please, change login.");
            }
        }

        if (login.length() < 6 || login.length() > 32) {
            errorsMessages.add("Incorrect login length! Your login length must be between 6 and 32 characters.");
        }

        if (login.contains(" ")) {
            errorsMessages.add("Remove space symbol from the login!");
        }

        if (password.length() < 8 || password.length() > 32) {
            errorsMessages.add("Password is too short! The minimum password length is 8 characters, and the maximum is 32.");
        }

        if (!password.matches("^(?=.*[!@#$%^&*()_+=\\[\\]{};:'\",<.>/?a-zA-Zа-яА-Я])(?=.*\\d).*$")) {
            errorsMessages.add("Password must contain at least one Russian/English letter, special symbol, and digit.");
        }

        String datePattern = "\\d{2}.\\d{2}.\\d{4}";
        if (birthDay == null) {
            errorsMessages.add("Invalid date format. Please use the format dd.MM.yyyy.");
        } else if (!birthDay.matches(datePattern)) {
            errorsMessages.add("Invalid date format. Please use the format dd.MM.yyyy.");
        }

        if (birthDay != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate dateOfBirth = LocalDate.parse(birthDay, formatter);
            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(dateOfBirth, currentDate);
            if (age.getYears() < 12) {
                errorsMessages.add("Age must be greater than or equal to 12 years.");
            }
        }

        if (!errorsMessages.isEmpty()) {
            throw new ValidationException(errorsMessages);
        }
    }

}
