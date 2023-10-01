package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IMessageService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IStsatisticService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api.IUserRegistrationService;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.MessageServiceFactory;
import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.factory.UserRegistrationFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class StatisticsService implements IStsatisticService {

    private final static StatisticsService instance = new StatisticsService();

    private final AtomicLong sessionCounter;
    private final IUserRegistrationService userService;
    private final IMessageService messageService;

    private StatisticsService() {
        this.sessionCounter = new AtomicLong(0);
        this.userService = UserRegistrationFactory.getInstance();
        this.messageService = MessageServiceFactory.getInstance();
    }

    @Override
    public Map<String, Object> getStats() {
        Map <String, Object> stats = new ConcurrentHashMap<>();
        stats.put("Количество пользователей", this.userService.getCount());
        stats.put("Количество сообзений", this.messageService.getCount());
        stats.put("Количество активных сессий", this.getSessionCount());

        return stats;
    }


    @Override
    public long incSession() {
        return this.sessionCounter.incrementAndGet();
    }

    @Override
    public long decSession() {
        return this.sessionCounter.decrementAndGet();
    }

    @Override
    public long getSessionCount() {
        return this.sessionCounter.get();
    }

    public static StatisticsService getInstance(){return instance;}
}
