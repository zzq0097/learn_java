package com.zzq.learn.ago.learn.eventbus;

import com.google.common.eventbus.Subscribe;

public class EventListener {
    @Subscribe
    public void listener(Event event) {
        System.out.println(event.getMessage());
    }
}
