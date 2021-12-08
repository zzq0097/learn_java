package com.zzq.learn.enums;

import com.zzq.learn.model.result.R;

public enum SysError {
    Forbidden(403, "无权限"),
    Undefined(R.ERROR, "未定义错误");

    public final int code;
    public final String msg;
    SysError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
