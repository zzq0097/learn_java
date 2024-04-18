package com.zzq.learn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("sse")
public class SSEController {

    @RequestMapping("connect")
    public SseEmitter connect() throws IOException {
        SseEmitter emitter = new SseEmitter();
        emitter.send("connect");
        for (int i = 0; i <= 10; i++) {
            emitter.send(i * 10 + "%");
        }
        emitter.complete();
        return emitter;
    }
}
