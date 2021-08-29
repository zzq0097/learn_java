package com.zzq.learn.model.result;

import lombok.Data;

import java.util.List;

@Data
public class PageData {
    private Long total;
    private List<?> list;
}
