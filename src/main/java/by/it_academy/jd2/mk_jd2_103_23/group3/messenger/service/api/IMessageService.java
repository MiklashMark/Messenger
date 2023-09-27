package by.it_academy.jd2.mk_jd2_103_23.group3.messenger.service.api;

import by.it_academy.jd2.mk_jd2_103_23.group3.messenger.core.dto.Message;

public interface IMessageService {

    void save(Message message);

    void send(Message message);

}