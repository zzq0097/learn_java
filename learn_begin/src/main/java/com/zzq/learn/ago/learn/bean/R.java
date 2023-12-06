package com.zzq.learn.ago.learn.bean;

/**
 * @author ZZQ
 * @date 2021/08/01
 */
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public final static int OK = 1;
    public final static int ERROR = 0;

    /**
     * method
     */
    public static <T> R<T> ok() {
        return new R<>(OK, "success", null);
    }

    public static <T> R<T> fail() {
        return new R<>(ERROR, "error", null);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(OK, "success", data);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(ERROR, msg, null);
    }

    public static <T> R<T> fail(String msg, T data) {
        return new R<>(ERROR, msg, data);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
