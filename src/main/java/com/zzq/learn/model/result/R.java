package com.zzq.learn.model.result;

public class R {
    private int code;
    private String msg;
    private Object data;

    public static final int SUCCESS = 0;
    public static final int ERROR = 1;

    /** method */
    public static R ok() {
        return new R(SUCCESS,"success");
    }
    public static R fail() {
        return new R(ERROR,"error");
    }

    public static R ok(Object data) {
        return new R(data);
    }
    public static R fail(String msg) {
        return new R(ERROR, msg);
    }
    public static R fail(String msg, Object data) {
        return new R(ERROR, msg, data);
    }

    /** constructor */
    public R() {}

    // success
    private R(Object data) {
        this.code = SUCCESS;
        this.msg = "success";
        this.data = data;
    }

    private R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /** getter,setter */
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

    public void setData(Object data) {
        this.data = data;
    }
}
