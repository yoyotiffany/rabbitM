package com.coolmq.amqp.controlly;

import com.coolmq.amqp.annotation.TransMessage;
import com.coolmq.amqp.util.sendMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author：yq
 * date: 2020/11/26
 */
@Controller
public class test {

    @Autowired
    sendMsg msg;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1() {
        try {
            msg.SendPhoneMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }



}
