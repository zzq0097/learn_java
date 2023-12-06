package com.zzq.learn.ago.learn.util;

public enum DateUtil {
    DEFAULT("yyyy-MM-dd HH:mm:ss Z"),
    NGINX("dd/MMM/yyyy:HH:mm:ss Z");
    protected final String str;

    DateUtil(String str) {
        this.str = str;
    }

    public String s() {
        return "";
    }

    ;

    @Override
    public String toString() {
        return str;
    }

}

