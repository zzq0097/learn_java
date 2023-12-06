package com.zzq.learn.ago.learn.myenum;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.RuntimeUtil;
import cn.hutool.core.util.StrUtil;
import com.zzq.learn.ago.learn.bean.NgxCmdResult;

import java.util.Optional;

public interface NgxUtil {
    enum Param1 {
        STOP("{} -s stop"),
        QUIT("{} -s quit"),
        REOPEN("{} -s reopen"),
        VERSION("{} -v"),
        CONFIGURE("{} -V");
        private final String template;

        Param1(String template) {
            this.template = template;
        }

        public String cmd(String bin) {
            return StrUtil.format(template, bin);
        }

        public String exec(String bin) {
            return NgxUtil.execForStr(cmd(bin));
        }

        public NgxCmdResult process(String bin) {
            return NgxUtil.process(cmd(bin));
        }
    }

    enum Param2 {
        START("{} -c {}"),
        RELOAD("{} -s reload -c {}"),
        CHECK("{} -t -c {}"),
        DUMP_CONF("{} -T -c {}");
        private final String template;

        Param2(String template) {
            this.template = template;
        }

        public String cmd(String bin, String conf) {
            return StrUtil.format(template, bin, conf);
        }

        public String exec(String bin, String conf) {
            return NgxUtil.execForStr(cmd(bin, conf));
        }

        public NgxCmdResult process(String bin, String conf) {
            return NgxUtil.process(cmd(bin, conf));
        }
    }

    enum SIGNAL {
        // nginx -s reload
        HUP("kill -HUP {}"),
        // nginx -s stop
        TERM("kill -TERM {}"),
        // nginx -s quit
        QUIT("kill -QUIT {}"),
        // nginx -s reopen
        USR1("kill -USR1 {}"),
        // 平滑升级 同时启动新的进程
        USR2("kill -USR2 {}"),
        // 从容关闭工作进程
        WINCH("kill -WINCH {}");
        private final String template;

        SIGNAL(String template) {
            this.template = template;
        }

        public String cmd(String pid) {
            return StrUtil.format(template, pid);
        }

        public String execForStr(String pid) {
            return NgxUtil.execForStr(cmd(pid));
        }

        public NgxCmdResult process(String pid) {
            return NgxUtil.process(cmd(pid));
        }
    }

    static String execForStr(String cmd) {
        return RuntimeUtil.execForStr("/bin/sh", "-c", cmd);
    }

    static NgxCmdResult process(String cmd) {
        NgxCmdResult ngxCmdResult = new NgxCmdResult();
        ngxCmdResult.setCmd(cmd);
        Process process;
        try {
            process = RuntimeUtil.exec("/bin/bash", "-c", cmd);
            ngxCmdResult.setResult(IoUtil.read(process.getInputStream()).toString());
            ngxCmdResult.setExitCode(process.exitValue());
        } catch (Exception e) {
            ngxCmdResult.setResult(e.getMessage());
            ngxCmdResult.setExitCode(-1);
        }
        return ngxCmdResult;
    }

    static Optional<String> version(String bin) {
        String flag = "nginx version: ";
        String stdout = Param1.VERSION.exec(bin);
        if (!stdout.startsWith(flag)) {
            return Optional.empty();
        }
        return Optional.of(stdout.substring(0, stdout.indexOf("\n")).substring(flag.length()));
    }

    static Optional<String> configure(String bin) {
        String flag = "configure arguments: ";
        String stdout = Param1.CONFIGURE.exec(bin);
        if (!stdout.contains(flag)) {
            return Optional.empty();
        }
        return Optional.of(stdout.substring(stdout.indexOf(flag) + flag.length()));
    }

}


