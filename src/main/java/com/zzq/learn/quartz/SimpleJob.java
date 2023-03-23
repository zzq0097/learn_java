package com.zzq.learn.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

@Slf4j
public class SimpleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail jobDetail = context.getJobDetail();
        JobDataMap jobDataMap = jobDetail.getJobDataMap();
        Long projectId = jobDataMap.getLong("projectId");;

        log.info("SimpleJob -> execute --- jobDetail: {}", context.getJobDetail());
    }
}
