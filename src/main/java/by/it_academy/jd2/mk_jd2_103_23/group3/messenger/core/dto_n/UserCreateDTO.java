package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserCreateDTO {
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String birthday;

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

    public String  getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
