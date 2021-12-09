package com.zzq.learn.consts;

import org.springframework.boot.system.ApplicationHome;

public interface Sys {
    String JarHome = new ApplicationHome().getDir().toString();

}
