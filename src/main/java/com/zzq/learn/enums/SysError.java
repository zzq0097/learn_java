package com.zzq.learn.enums;

import com.zzq.learn.model.result.R;

public enum SysError {
    Forbidden(403, "无权限"),
    InvalidArgument(599, "字段验证错误"),
    AddFail(598, "添加失败"),
    UpdateFail(597, "更新失败"),
    DelFail(576, "删除失败"),
    DataRepeat(577, "数据重复"),
    CodeFail(513,"验证码错误"),
    LoginFail(511, "密码错误"),
    Undefined(R.UndefinedError, "未定义错误");

    public final int code;
    public final String msg;

    SysError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
