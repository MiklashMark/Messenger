package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import java.util.Map;

public interface IStsatisticService {
    long incSession();
    long decSession();

    /**
     * Returns total count of sessions;
     * @return
     */
    long getSessionCount();


    /**
     * Get map of total count active users, registered users and messages;
     * @return
     */
    Map<String, Object> getStats();
}
