package com.zzq.learn.ago.learn.bean;

import lombok.Data;

@Data
public class ApiParam {
    String in;
    String name;
    String type;
    boolean required;
    Object data;
}
