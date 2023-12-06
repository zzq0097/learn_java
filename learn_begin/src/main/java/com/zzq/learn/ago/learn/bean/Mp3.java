package com.zzq.learn.ago.learn.bean;

import lombok.Data;

import java.util.Map;

@Data
public class Mp3 {
    String author;
    String title;
    String album;
    int bitRate;
    int sampleRate;

    private Map<String, String> tags;

    public static Mp3 parse(String path) {
        return new Mp3(path);
    }

    private Mp3(String path) {


    }


}
