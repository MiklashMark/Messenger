package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String birthDay;

    private LocalDateTime registrationDate;
    private boolean isAdministrator = false;

    public User() {
    }

    public User(String login, String password, boolean isAdministrator) {
        this.login = login;
        this.password = password;
        this.isAdministrator = isAdministrator;
    }

    public User(String login, String password, String firstName,
                String lastName, String birthDay,
                LocalDateTime registrationDate, boolean isAdministrator) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.registrationDate = registrationDate;
        this.isAdministrator = isAdministrator;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(boolean administrator) {
        isAdministrator = administrator;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", registrationDate=" + registrationDate +
                ", isAdministrator=" + isAdministrator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isAdministrator == user.isAdministrator && Objects.equals(login, user.login) && Objects.equals(password, user.password) && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(birthDay, user.birthDay) && Objects.equals(registrationDate, user.registrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, firstName, lastName, birthDay, registrationDate, isAdministrator);
    }
}
