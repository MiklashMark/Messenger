package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.User;

import java.util.List;

public interface IUserDao {


    /**
     * Adds registered user in UserDao;
     * @param user
     */
    void save(User user);


    /**
     * Returns all registered users;
     * @return
     */
    List<User> getUsers();
}
