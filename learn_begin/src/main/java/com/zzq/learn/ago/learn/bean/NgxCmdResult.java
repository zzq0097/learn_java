package com.zzq.learn.ago.learn.bean;

import lombok.Data;

@Data
public class NgxCmdResult {
    private String cmd;
    private Integer exitCode;
    private String result;
}
