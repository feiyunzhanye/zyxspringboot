package com.ideal.zyxspringboot.activeMQ;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AyMoodConsumer {
    @JmsListener(destination = "ay.queue")
    public void receiveQueue(String text){
        System.out.println("用户发表说说【"+text+"】成功");
    }
}
