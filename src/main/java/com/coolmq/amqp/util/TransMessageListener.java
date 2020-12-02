package com.coolmq.amqp.util;

import com.coolmq.amqp.listener.AbstractMessageListener;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class TransMessageListener extends AbstractMessageListener {

    @Override
    public void receiveMessage(Message message) {
        int a=9/0;
        logger.info(new String(message.getBody()));
    }

}