package com.zzq.learn.ago.learn.test;

import com.zzq.learn.ago.learn.myenum.MsgType;
import com.zzq.learn.ago.learn.util.ReqUtil;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocketTest {
    final static String IP = "192.168.31.104";
    final static int PORT = 7000;

    public static void main(String[] args) {
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            socket = new Socket(IP, PORT);
            in = socket.getInputStream();
            out = new BufferedOutputStream(socket.getOutputStream());
            while (true) {
                Scanner input = new Scanner(System.in);
                switch (input.nextInt()) {
                    case 1:
                        ReqUtil.send(out, MsgType.reqLoginAlarm, "user=yiy;key=qw#$@;type=msg");
                        System.out.println(ReqUtil.receive(in));
                        break;
                    case 2:
                        ReqUtil.send(out, MsgType.reqSyncAlarmMsg, "dasd=ad;dsd=22");
                        System.out.println(ReqUtil.receive(in));
                        break;
                    case 3:
                        ReqUtil.send(out, MsgType.reqHeartBeat, "dasd=ad;dsd=22");
                        System.out.println(ReqUtil.receive(in));
                        break;
                    default:
                        System.out.println("未定义的请求");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                if (socket != null) socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
