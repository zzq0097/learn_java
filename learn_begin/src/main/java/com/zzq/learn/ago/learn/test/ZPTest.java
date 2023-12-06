package com.zzq.learn.ago.learn.test;

import org.apache.zeppelin.client.ClientConfig;
import org.apache.zeppelin.client.ZeppelinClient;

import java.util.HashMap;
import java.util.Map;

public class ZPTest {

    public static void main(String[] args) throws Exception {
        ZeppelinClient zClient = new ZeppelinClient(new ClientConfig("http://192.168.31.102:8081"));
        zClient.login("admin", "12345678");
        Map<String, String> map = new HashMap<>();
        map.put("hh", "12345343");
        zClient.executeParagraph("2J2QVA3C6", "paragraph_1687931324613_106405733", map);

    }


}
