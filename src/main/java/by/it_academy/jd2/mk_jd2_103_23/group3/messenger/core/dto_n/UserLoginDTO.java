package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto_n;

public class UserLoginDTO {
    private String login;
    private String password;

    public UserLoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
