package com.highman.cron;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class GameStatusUpdateJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        String id = jobDataMap.getString("id");
        String action = jobDataMap.getString("action");

        System.out.println("concacccc: " + id + " - " + action);
    }
}
