package com.zzq.learn.model.dto;

import lombok.Data;

@Data
public class PageDTO {
    private Long curr;
    private Long size;

    public PageDTO() {
        this.curr = 1L;
        this.size = 10L;
    }
}
