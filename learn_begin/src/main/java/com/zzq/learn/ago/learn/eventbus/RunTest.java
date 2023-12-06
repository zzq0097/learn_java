package com.zzq.learn.ago.learn.eventbus;

import com.google.common.eventbus.EventBus;

public class RunTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new EventListener());
        eventBus.post(new Event("test"));

    }
}
