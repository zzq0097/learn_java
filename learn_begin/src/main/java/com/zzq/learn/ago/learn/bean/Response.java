package com.zzq.learn.ago.learn.bean;

import com.zzq.learn.ago.learn.myenum.MsgType;
import lombok.Data;

@Data
public class Response {
    short head;
    MsgType msgType;
    short lenOfBody;
    int timeStamp;
    String body;
}
