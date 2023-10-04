package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n;

import java.time.LocalDate;

public class UserCreateDTO {
    private String login;
    private String password;
    private String fio;
    private LocalDate birthday;

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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
