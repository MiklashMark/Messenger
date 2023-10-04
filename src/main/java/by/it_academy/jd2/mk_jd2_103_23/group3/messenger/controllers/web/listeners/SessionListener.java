package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.controllers.web.listeners;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.StatisticsService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IStsatisticService;
import jakarta.servlet.http.*;


/**
 * Listener is used for retrieve current count of active users,
 * registered users and total messages;
 */
public class SessionListener implements HttpSessionAttributeListener {
    private final IStsatisticService statisticService;

    public SessionListener() {
        this.statisticService = StatisticsService.getInstance();
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        if("user".equalsIgnoreCase(event.getName()) && event.getValue() != null){
            this.statisticService.incSession();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        if("user".equalsIgnoreCase(event.getName())){
            this.statisticService.decSession();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        if("user".equalsIgnoreCase(event.getName())){
            if(event.getValue() != null){
                this.statisticService.decSession();
                this.statisticService.incSession();
            } else {
                this.statisticService.decSession();
            }
        }
    }
}
