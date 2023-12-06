package com.zzq.learn.ago.learn.myenum;

public enum StateCode {
    SUCCESS(200),
    ERROR(500);

    private final int code;

    StateCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

}
