package com.highman.cron;

import com.mongodb.reactivestreams.client.MongoCollection;
import org.bson.Document;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
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

    public static void setSchedule(List<List<Object>> schedule) {
        for (List<Object> job: schedule) {
            try {
                JobDataMap jobDataMap = new JobDataMap();
                jobDataMap.put("id", job.get(0));

                if (job.get(1).equals("start")) {
                    JobDetail jobDetail = JobBuilder.newJob(GameStatusStartJob.class).setJobData(jobDataMap).build();
                    LocalDateTime localDateTime = ((Date) job.get(2)).toInstant()
                            .atZone(ZoneId.of("GMT")).toLocalDateTime();
                    String cronExpression = String.format("%s %s %s %s %s %s %s", localDateTime.getSecond(), localDateTime.getMinute(), localDateTime.getHour(), localDateTime.getDayOfMonth(), localDateTime.getMonth().getValue(), "?", localDateTime.getYear());
                    CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();

                    scheduler.scheduleJob(jobDetail, trigger);

                    System.out.printf("Job to update game \"%s\" (action \"%s\") has been scheduled for execution at: %s\n", job.get(0), job.get(1), localDateTime);
                }
                else {
                    JobDetail jobDetail = JobBuilder.newJob(GameStatusEndJob.class).setJobData(jobDataMap).build();
                    LocalDateTime localDateTime = ((Date) job.get(2)).toInstant()
                            .atZone(ZoneId.of("GMT")).toLocalDateTime();
                    String cronExpression = String.format("%s %s %s %s %s %s %s", localDateTime.getSecond(), localDateTime.getMinute(), localDateTime.getHour(), localDateTime.getDayOfMonth(), localDateTime.getMonth().getValue(), "?", localDateTime.getYear());
                    CronTrigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();

                    scheduler.scheduleJob(jobDetail, trigger);

                    System.out.printf("Job to update game \"%s\" (action \"%s\") has been scheduled for execution at: %s\n", job.get(0), job.get(1), localDateTime);
                }
            } catch (SchedulerException e) {
                System.out.printf("Failure while scheduling job: %s. Skipping...\n", e.getMessage());
            }
        }

        try {
            scheduler.start();
        } catch (SchedulerException e) {
            System.out.println("Failure to start game status scheduler");
            e.printStackTrace();
        }
    }
}
