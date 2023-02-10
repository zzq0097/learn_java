package com.zzq.learn.event;

import org.springframework.context.event.EventListener;

public class BizEventListener {

    @EventListener
    public void loginHandler(LoginEvent event) {
        System.out.println(event.getUser().getNickname());
    }
}
