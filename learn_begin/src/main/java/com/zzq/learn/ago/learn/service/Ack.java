package com.zzq.learn.ago.learn.service;

import com.zzq.learn.ago.learn.bean.Response;

import java.nio.ByteBuffer;

public interface Ack {
    ByteBuffer ack(Response response);
}
