package com.zzq.learn.ago.learn.service;


import cn.hutool.core.util.NumberUtil;
import cn.hutool.system.oshi.OshiUtil;
import com.sun.management.OperatingSystemMXBean;
import com.zzq.learn.ago.learn.bean.DiskInfo;
import com.zzq.learn.ago.learn.bean.MonitorInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;


@Service
public class SysInfoService {
    OperatingSystemMXBean osmxb;

    @PostConstruct
    private void init() {
        osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    /**
     * 查看cpu占用
     */
    public MonitorInfo getMonitorInfoOshi() {
        MonitorInfo infoBean = new MonitorInfo();
        infoBean.setCpuCount(OshiUtil.getProcessor().getPhysicalProcessorCount());
        infoBean.setThreadCount(OshiUtil.getProcessor().getLogicalProcessorCount());
        infoBean.setUsedMemory(FormatUtil.formatBytes(OshiUtil.getMemory().getTotal() - OshiUtil.getMemory().getAvailable()));
        infoBean.setTotalMemorySize(FormatUtil.formatBytes(OshiUtil.getMemory().getTotal()));
        infoBean.setCpuRatio(NumberUtil.decimalFormat("#.##%", osmxb.getSystemCpuLoad()));
        infoBean.setMemRatio(NumberUtil.decimalFormat("#.##%", NumberUtil.div(OshiUtil.getMemory().getTotal() - OshiUtil.getMemory().getAvailable(), OshiUtil.getMemory().getTotal())));
        return infoBean;
    }

    /**
     * 查看磁盘空间
     */
    public List<DiskInfo> getDiskInfo() {
        List<DiskInfo> list = new ArrayList<>();
        for (OSFileStore fs : OshiUtil.getOs().getFileSystem().getFileStores()) {
            DiskInfo diskInfo = new DiskInfo();

            diskInfo.setPath(fs.getMount());
            diskInfo.setUseSpace(FormatUtil.formatBytes(fs.getTotalSpace() - fs.getUsableSpace()));
            diskInfo.setTotalSpace(FormatUtil.formatBytes(fs.getTotalSpace()));
            if (fs.getTotalSpace() != 0) {
                diskInfo.setPercent(NumberUtil.decimalFormat("#.##%", NumberUtil.div(fs.getTotalSpace() - fs.getUsableSpace(), fs.getTotalSpace())));
            } else {
                diskInfo.setPercent(NumberUtil.decimalFormat("#.##%", 0));
            }
            list.add(diskInfo);
        }
        return list;
    }
}
