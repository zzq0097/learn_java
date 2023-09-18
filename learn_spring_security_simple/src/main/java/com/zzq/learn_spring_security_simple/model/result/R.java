package com.zzq.learn_spring_security_simple.model.result;

public class R<T> {
    private int code;
    private String msg;
    private T data;

    public static final int SUCCESS = 1;
    public static final int ERROR = 0;

    /**
     * method
     */
    public static <T> R<T> ok() {
        return new R<>(SUCCESS, "success", null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(SUCCESS, "success", data);
    }

    public static <T> R<T> fail() {
        return new R<>(ERROR, "error", null);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(ERROR, msg, null);
    }


    /**
     * constructor
     */
    private R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * getter,setter
     */
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
