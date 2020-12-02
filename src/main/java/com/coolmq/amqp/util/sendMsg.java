package com.coolmq.amqp.util;

import com.coolmq.amqp.annotation.TransMessage;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * author：yq
 * date: 2020/11/27
 */
@Component
public class sendMsg {
    @TransMessage(exchange = "YQ_TEST",bindingKey = "test.yq", bizName = "yq测试",
            dbCoordinator = "DBRedisCoordinator")
    public Map<String, Object> SendPhoneMessage() {
        //发消息
        Map<String, Object> map = new HashMap<>();
        map.put("yq", "yqtest1");
        return map;
    }
}
