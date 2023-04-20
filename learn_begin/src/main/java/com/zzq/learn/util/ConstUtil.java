package com.zzq.learn.util;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.setting.yaml.YamlUtil;
import com.zzq.learn.model.sys.DataSource;

public class ConstUtil {

    public static DataSource getDataSource() {
        Dict yaml = YamlUtil.load(ResourceUtil.getUtf8Reader("application.yml"));
        return yaml.getByPath("spring.datasource", DataSource.class);
    }

}
