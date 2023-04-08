package com.zzq.learn.consts;

import com.zzq.learn.model.sys.DataSource;
import com.zzq.learn.util.ConstUtil;
import org.springframework.boot.system.ApplicationHome;

public interface Sys {
    String JarHome = new ApplicationHome().getDir().toString();

    int AvailableProcessors = Runtime.getRuntime().availableProcessors();

    String Tab = "    ";

    DataSource DataSource = ConstUtil.getDataSource();

}
