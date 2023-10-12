package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.listeners;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.User;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.UserDao;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.dao.factory.UserDaoFactory;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DefaultDataInitializer implements ServletContextListener {

    // Add default admin initialization to listeners
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserDao userDao = UserDaoFactory.getInstance();

        User admin = new User("admin", "admin", "admin", "admin",
                LocalDate.of(1969, 1, 1), LocalDateTime.now(),true);

        userDao.save(admin);
    }
}
