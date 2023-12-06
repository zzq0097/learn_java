package com.zzq.learn.ago.learn.myenum;

import cn.hutool.core.util.StrUtil;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum NgxCmd2 {
    STOP("{} -s stop"),
    VERSION("{} -v"),
    CONFIGURE("{} -V"),
    START("{} -c {}"),
    RELOAD("{} -s reload -c {}"),
    CHECK("{} -t -c {}"),
    DUMP_CONF("{} -T -c {}");
    private final String template;

    NgxCmd2(String template) {
        this.template = template;
    }

    static final Map<NgxCmd2, BiFunction<String, String, String>> map = new EnumMap<>(NgxCmd2.class);

    static {
        map.put(STOP, (bin, conf) -> cmd1(STOP, bin));
        map.put(START, (bin, conf) -> cmd2(START, bin, conf));
    }

    public static String cmd1(NgxCmd2 cmd1, String bin) {
        return StrUtil.format(cmd1.template, bin);
    }

    public static String cmd2(NgxCmd2 cmd2, String bin, String conf) {
        return StrUtil.format(cmd2.template, bin, conf);
    }

    public String exec(NgxCmd2 cmd, String bin, String conf) {
        return map.get(cmd).apply(bin, conf);
    }
}
