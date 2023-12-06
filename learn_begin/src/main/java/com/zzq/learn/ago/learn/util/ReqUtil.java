package com.zzq.learn.ago.learn.util;

import com.zzq.learn.ago.learn.bean.Response;
import com.zzq.learn.ago.learn.myenum.MsgType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class ReqUtil {

    // --- ByteBuffer
    public static Response parse(ByteBuffer buffer) {
        Response response = new Response();
        buffer.flip();
        short begin = buffer.getShort(0);
        if (begin == -1) {
            response.setHead(begin);
            response.setMsgType(getType(buffer.get(2)));
            response.setTimeStamp(buffer.getInt(3));
            short lenOfBody = buffer.getShort(7);
            response.setLenOfBody(lenOfBody);
            byte[] body = new byte[lenOfBody];
            buffer.position(9);
            buffer.get(body, 0, lenOfBody);
            response.setBody(new String(body));
            System.out.println(response);
            return response;
        }
        return null;
    }

    public static ByteBuffer builder(MsgType msgType, String body) {
        if (!MsgType.realTimeAlarm.equals(msgType)) {
            body = msgType.name() + ";" + body;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(body.getBytes().length + 9);
        byteBuffer.putShort((short) 0xFFFF);
        byteBuffer.put((byte) msgType.idx);
        byteBuffer.putInt((int) (System.currentTimeMillis() / 1000));
        byteBuffer.putShort((short) body.getBytes().length);
        byteBuffer.put(body.getBytes());
        byteBuffer.flip();
        return byteBuffer;
    }

    public static MsgType getType(int msgType) {
        for (MsgType type : MsgType.class.getEnumConstants()) {
            if (type.idx == msgType) {
                return type;
            }
        }
        return MsgType.error;
    }

    // --- byte[]
    public static Response receive(InputStream in) throws IOException {
        Response response = new Response();
        byte[] headByte = new byte[2];
        in.read(headByte);
        int head = byteArrayToInt(headByte);
        response.setHead((short) head);
        if (head == 0xFFFF) {
            byte[] msgType = new byte[1];
            in.read(msgType);
            response.setMsgType(getType(msgType[0]));
            byte[] timeStamp = new byte[4];
            in.read(timeStamp);
            response.setTimeStamp(byteArrayToInt(timeStamp));
            byte[] lenOfBody = new byte[2];
            in.read(lenOfBody);
            int len = byteArrayToInt(lenOfBody);
            response.setLenOfBody((short) len);
            byte[] data = new byte[len];
            in.read(data);
            response.setBody(new String(data));
            return response;
        }
        return null;
    }

    public static void send(OutputStream out, MsgType msgType, String params) throws IOException {
        send(out, msgType.idx, msgType.name() + ";" + params);
    }

    public static void send(OutputStream out, String json) throws IOException {
        send(out, 0, json);
    }

    public static void send(OutputStream out, int msgType, String body) throws IOException {
        out.write(intTo2ByteArray(0xFFFF));
        out.write(msgType);
        out.write(intTo4ByteArray((int) (System.currentTimeMillis() / 1000)));
        byte[] bytes = body.getBytes();
        out.write(intTo2ByteArray(bytes.length));
        out.write(bytes);
        out.flush();
    }

    public static Map<String, String> bodyToMap(String body) {
        Map<String, String> map = new HashMap<>();
        String[] params = body.split(";");
        for (int i = 1; i < params.length; i++) {
            String[] kv = params[i].split("=");
            map.put(kv[0], kv.length < 2 ? "null" : kv[1]);
        }
        return map;
    }

    public static byte[] intTo4ByteArray(int i) {
        byte[] result = new byte[4];
        result[0] = (byte) ((i >> 24) & 0xFF);
        result[1] = (byte) ((i >> 16) & 0xFF);
        result[2] = (byte) ((i >> 8) & 0xFF);
        result[3] = (byte) (i & 0xFF);
        return result;
    }

    public static byte[] intTo2ByteArray(int i) {
        byte[] result = new byte[2];
        result[0] = (byte) ((i >> 8) & 0xFF);
        result[1] = (byte) (i & 0xFF);
        return result;
    }

    public static int byteArrayToInt(byte[] bytes) {
        int value = 0;
        int len = bytes.length;
        for (int i = 0; i < len; i++) {
            int shift = (len - 1 - i) * 8;
            value += (bytes[i] & 0xFF) << shift;
        }
        return value;
    }
}
