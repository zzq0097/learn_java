package com.zzq.learn.ago.learn.test;

import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class ClientChannelTest {
    SocketChannel channel;

    public static void main(String[] args) throws Exception {
        ClientChannelTest test = new ClientChannelTest();
    }

    ClientChannelTest() throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999);
        channel = socket.getChannel();
        System.out.println("client socket 启动");
        if (channel != null && channel.isConnected()) {
            this.clientSend();
        }
    }

    public byte clientReceive() throws Exception {
        ByteBuffer b = ByteBuffer.allocate(1);
        channel.read(b);
        System.out.println(b);
        return b.get(0);
    }

    public void clientSend() throws Exception {
        String body = "hello";
        ByteBuffer byteBuffer = ByteBuffer.allocate(body.getBytes().length + 9);
        byteBuffer.putShort((short) 0xFFFF);
        byteBuffer.put((byte) 1);
        byteBuffer.putInt((int) (System.currentTimeMillis() / 1000));
        byteBuffer.putShort((short) body.getBytes().length);
        byteBuffer.put(body.getBytes());
        channel.write(byteBuffer);
//        channel.write(ByteBuffer.wrap(new byte[]{127}));
    }


}
