package com.zzq.learn.model.dto.base;

import lombok.Data;

@Data
public class QueryDTO {
    private Long Id;
    private Long page;
    private Long pageSize;
}
