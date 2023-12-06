package com.zzq.learn.ago.learn.service;

import com.zzq.learn.ago.learn.bean.Response;
import com.zzq.learn.ago.learn.dao.UserDao;
import com.zzq.learn.ago.learn.myenum.MsgType;
import com.zzq.learn.ago.learn.test.ServerSocketRunner;
import com.zzq.learn.ago.learn.util.ReqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;

@Service
public class AckService {
    @Autowired
    private UserDao userDao;
    @Lazy
    @Autowired
    ServerSocketRunner server;

    public void dealWith(Response response, SocketChannel channel) throws Exception {
        ByteBuffer ack = ReqUtil.builder(MsgType.error, "请求未处理");
        if (response != null) {
            String body = response.getBody();
            switch (response.getMsgType()) {
                case reqLoginAlarm:
                    System.out.println(userDao.page(1, 10));
                    Map<String, String> map = ReqUtil.bodyToMap(body);
                    if (map.get("user").equals("yiy") && map.get("key").equals("qw#$@")) {
                        ack = ReqUtil.builder(MsgType.ackLoginAlarm, "result=succ;resDesc=null");
                    } else {
                        ack = ReqUtil.builder(MsgType.ackLoginAlarm, "result=fail;resDesc=null");
                    }
                    break;
                case reqHeartBeat:
                    ack = ReqUtil.builder(MsgType.ackHeartBeat, "心跳相应");
                    break;
                case reqSyncAlarmMsg:
                    ack = ReqUtil.builder(MsgType.ackSyncAlarmMsg, "消息同步");
                    break;
                case realTimeAlarm:
                    ack = ReqUtil.builder(MsgType.ackSyncAlarmFileResult, "json");
                    break;
            }
            write(ack, channel);
        }
    }

    public void write(ByteBuffer byteBuffer, SocketChannel channel) throws Exception {
        channel.register(server.selector, SelectionKey.OP_WRITE, byteBuffer);
    }
}
