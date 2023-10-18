package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.listeners;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.entity.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.UserDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory.UserDaoFactory;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DefaultDataInitializer implements ServletContextListener {
    private final UserDao userDao = UserDaoFactory.getInstance();

    // Add default admin initialization to listeners
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        if (!isAdminExist()) {
            User admin = new User("admin", "admin", "admin", "admin",
                    LocalDate.of(1969, 1, 1), LocalDateTime.now(), true);

            userDao.save(admin);
        }
    }

    private boolean isAdminExist() {
        boolean isAdminExist = userDao.getUsers().stream().anyMatch(u -> "admin".equalsIgnoreCase(u.getLogin())
                && "admin".equalsIgnoreCase(u.getPassword()));
        System.out.println(isAdminExist);
        return isAdminExist;

    }
}
