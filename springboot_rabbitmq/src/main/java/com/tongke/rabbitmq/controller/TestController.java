package com.tongke.rabbitmq.controller;


import com.tongke.rabbitmq.entity.Order;

import com.tongke.rabbitmq.factory.NeoSender;
import com.tongke.rabbitmq.helloword.HelloSender;
import com.tongke.rabbitmq.mukewang.sender.*;
import com.tongke.rabbitmq.subscribe.FanoutSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    //慕课网
    @Autowired
    private Sender sender;
    @RequestMapping("hello")
    public String helloTest(){
        Order order = new Order(System.currentTimeMillis()+"order_id","order_test",System.currentTimeMillis()+"$");
        sender.sendOrder(order);
        return "success";
    }

    //helloword
    @Autowired
    private HelloSender helloSender;
    @RequestMapping("helloword")
    public String helloword(){
        helloSender.send();
        return "helloword";
    }

    //工厂模式（竞争）
    @Autowired
    private NeoSender neoSender;
    @RequestMapping("neoSender")
    public String neoSender(){
        for (int i=0;i<100;i++){
            neoSender.send(i);
        }
        return "neoSender";
    }

    //工厂模式（竞争）
    @Autowired
    private FanoutSender fanoutSender;
    @RequestMapping("fanoutSender")
    public String fanoutSender(){
        fanoutSender.send();
        return "fanoutSender";
    }
}
