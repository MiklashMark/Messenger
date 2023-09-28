package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.listeners;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class UserListener implements HttpSessionListener {
    private static  int activeUsers;

    public static int getActiveUsers(){
        return activeUsers;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        if (session.getAttribute("user") != null) {
            activeUsers++;
        }
    }

}
