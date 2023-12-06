package com.zzq.learn.ago.learn.controller.base;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    Integer total;
    List<T> list;
}
