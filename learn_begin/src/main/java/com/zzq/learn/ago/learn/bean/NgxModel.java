package com.zzq.learn.ago.learn.bean;

import lombok.Data;


@Data
public class NgxModel {
    // 依赖包文件夹   默认:/nginx/install
    String install;
    // nginx安装位置    默认:/nginx/nginx
    String prefix;
    String ngx;
    String zlib;
    String pcre;
    String openssl;
    String mods;
}
