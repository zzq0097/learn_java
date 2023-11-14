package com.zzq.learn.websocket;

import cn.hutool.core.io.IoUtil;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Slf4j
@ServerEndpoint("/ws")
public class WebSocketEndpoint {
    private final static Set<WebSocketEndpoint> webSockets = new HashSet<>();
    private static Boolean installing = false;
    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        log.info("onOpen");
        this.session = session;
        webSockets.add(this);
        for (WebSocketEndpoint webSocket : webSockets) {
            if (this.session != webSocket.session) {
                sendTo(webSocket.session, "sessionId:[" + this.session.getId() + "]连接了");
            }
        }
    }

    /**
     * 接收文本消息
     *
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        log.info("onMessage - String");
        if ("install".equals(message)) {
            if (installing) {
                sendText("安装脚本已执行");
                return;
            }
            try {
                installing = true;
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(5000);
                    sendText((i + 1) * 10 + "%");
                }
                this.session.getBasicRemote().sendText("安装成功");
            } catch (Exception e) {
                log.info("install error", e);
            } finally {
                installing = false;
            }
        }
    }

    /**
     * 接收二进制消息
     *
     * @param bytes
     */
    @OnMessage
    public void onMessage(byte[] bytes) {
        log.info("onMessage - byte");

    }

    @OnClose
    public void onClose() {
        log.info("onClose");
        IoUtil.close(session);
        webSockets.remove(this);
    }

    @OnError
    public void onError(Throwable throwable) {
        log.info("onError", throwable);
    }


    public void sendText(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.info("sendText error", e);
        }
    }

    public void sendTo(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            log.info("sendText error", e);
        }
    }
}
