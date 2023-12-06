package com.zzq.learn.ago.learn.controller.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResult {
    int code;
    String msg;
    Object data;
}
