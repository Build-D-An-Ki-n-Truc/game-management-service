package com.highman.cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;

public class GameStatusUpdateScheduler {
    public static Scheduler scheduler;
    
    static {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            scheduler = schedulerFactory.getScheduler();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setSchedule() throws SchedulerException {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("id", "a");
        jobDataMap.put("action", "beep");

        JobDetail jobDetail = JobBuilder.newJob(GameStatusUpdateJob.class).withIdentity("testJob", "group1").setJobData(jobDataMap).build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("testTrigger", "group1").withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
