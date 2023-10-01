package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import java.util.Map;

public interface IStsatisticService {

    long incSession();
    long decSession();
    long getSessionCount();

    Map<String, Object> getStats();
}
