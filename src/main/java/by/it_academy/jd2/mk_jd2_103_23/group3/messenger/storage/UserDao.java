package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.storage;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api.IUserDao;

import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao {
    private User admin = new User("admin", "admin", true);
    private final List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        synchronized (users) {
            users.add(user);
        }
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    public User getAdmin() {
        return admin;
    }
}