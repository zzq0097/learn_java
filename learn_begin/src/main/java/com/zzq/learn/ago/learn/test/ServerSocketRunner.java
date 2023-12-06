package com.zzq.learn.ago.learn.test;

import com.zzq.learn.ago.learn.service.AckService;
import com.zzq.learn.ago.learn.util.ReqUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;

@Component
public class ServerSocketRunner {
    @Autowired
    AckService ackService;

    public final Selector selector;
    private Map<SocketAddress, Boolean> loginStatus;

    public ServerSocketRunner() throws Exception {
        selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        server.bind(new InetSocketAddress(9999));
        server.configureBlocking(false);
        System.out.println("server socket 启动");
        server.register(selector, SelectionKey.OP_ACCEPT);
        new Thread(this::listen).start();
    }

//    public static void main(String[] args) throws Exception {
//        ServerSocketRunner runner = new ServerSocketRunner();
//    }

    public void listen() {
        while (true) try {
            if (selector.isOpen() && 0 != selector.select()) {
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    handler(key);
                    keyIterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handler(SelectionKey key) throws Exception {
        if (key.isAcceptable()) {
            System.out.println("acceptable");
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            SocketChannel channel = server.accept();
            System.out.println("客户端：" + channel.getRemoteAddress() + "已连接！");
            channel.configureBlocking(false);
            channel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            System.out.println("readable");
            SocketChannel channel = (SocketChannel) key.channel();
            channel.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(Short.MAX_VALUE + 9);
            try {
                while (channel.read(buffer) > 0) ;
                ackService.dealWith(ReqUtil.parse(buffer), channel);
//                channel.register(selector, SelectionKey.OP_WRITE, ackService.dealWith(buffer));
            } catch (Exception e) {
                e.printStackTrace();
                channel.close();
                System.out.println("客户端关闭连接！");
            }
        } else if (key.isWritable()) {
            System.out.println("writable");
            SocketChannel channel = (SocketChannel) key.channel();
            channel.configureBlocking(false);
            channel.write((ByteBuffer) key.attachment());
            channel.register(selector, SelectionKey.OP_READ);
        }
    }
}
