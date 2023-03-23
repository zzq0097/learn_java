package com.zzq.learn.quartz;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService {
    private final Scheduler scheduler;

    @PostConstruct
    public void addJob() throws SchedulerException {
        Long projectId = 1L;

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("projectId", projectId);

        JobDetail jobDetail = JobBuilder
                .newJob(SimpleJob.class)
                .setJobData(jobDataMap)
                .withIdentity(buildJobKey(projectId))
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(5)
                                .repeatForever()
                )
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        System.out.println(scheduler.getJobGroupNames());
        System.out.println(scheduler.getJobKeys(GroupMatcher.anyGroup()));
    }

    public void delJob(Long projectId) throws SchedulerException {
        scheduler.deleteJob(buildJobKey(projectId));
    }

    private JobKey buildJobKey(Long projectId) {
        return new JobKey(StrUtil.format("{}:projectId:{}", SimpleJob.class.getSimpleName(), projectId));
    }
}
