package com.zzq.learn.ago.learn.bean;

import lombok.Data;

import java.util.List;

@Data
public class Api {
    String path;
    List<Method> methods;
}
