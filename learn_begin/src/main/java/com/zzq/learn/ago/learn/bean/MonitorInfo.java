package com.zzq.learn.ago.learn.bean;


public class MonitorInfo {
    /**
     * 总的物理内存
     */
    private String totalMemorySize;
    /**
     * 已使用的物理内存
     */
    private String usedMemory;
    /**
     * cpu使用率
     */
    private String cpuRatio;
    /**
     * 内存使用率
     */
    private String memRatio;
    /**
     * cpu数量
     */
    private Integer cpuCount;
    /**
     * 线程数量
     */
    private Integer threadCount;

    public String getTotalMemorySize() {
        return totalMemorySize;
    }

    public void setTotalMemorySize(String totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public String getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(String usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getCpuRatio() {
        return cpuRatio;
    }

    public void setCpuRatio(String cpuRatio) {
        this.cpuRatio = cpuRatio;
    }

    public String getMemRatio() {
        return memRatio;
    }

    public void setMemRatio(String memRatio) {
        this.memRatio = memRatio;
    }

    public Integer getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(Integer cpuCount) {
        this.cpuCount = cpuCount;
    }

    public Integer getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Integer threadCount) {
        this.threadCount = threadCount;
    }
}
