package com.zzq.learn.model.result;

import com.zzq.learn.enums.SysError;

public class R<T> {
    private int code;
    private String msg;
    private T data;

    public static final int SUCCESS = 1;
    public static final int ERROR = 0;
    public static final int UndefinedError = -1;
    public static final int CustomError = -2;

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
        return new R<>(SysError.Undefined);
    }

    public static <T> R<T> fail(SysError error) {
        return new R<>(error);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(ERROR, msg, null);
    }

    public static <T> R<T> fail(SysError error, T data) {
        return new R<>(error.code, error.msg, data);
    }

    /**
     * constructor
     */
    private R() {
    }

    private R(SysError error) {
        this.code = error.code;
        this.msg = error.msg;
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
