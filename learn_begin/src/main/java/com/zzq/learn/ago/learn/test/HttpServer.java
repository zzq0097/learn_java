package com.zzq.learn.ago.learn.test;

import cn.hutool.socket.nio.NioServer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class HttpServer {

    public static void main(String[] args) throws Exception {

        NioServer nioServer = new NioServer(9999);
        nioServer.setChannelHandler(channel -> {
            ByteBuffer readBuffer = ByteBuffer.allocate(9 + Short.MAX_VALUE);
            channel.read(readBuffer);
            byte[] str = new byte[50];
            readBuffer.get(str);
            System.out.println(new String(str));
            channel.write(ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8)));
        }).listen();
    }
}
