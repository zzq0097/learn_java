package com.zzq.learn.ago.learn.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class BizEventListener {

    @Order(2)
    @EventListener
    public void eventHandler(String msg) {
        System.out.println("eventHandler:" + msg);
    }

    @EventListener
    public void eventHandler(Integer number) {
        System.out.println(number);
    }

    @Order(1)
    @EventListener
    public void eventHandler2(String msg) {
        System.out.println("eventHandler2:" + msg);
    }


}
