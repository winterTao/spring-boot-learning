package com.tao.spring.controller;

import com.tao.spring.job.Quartz;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author DongTao
 * @since 2019-03-25
 */
@RestController
public class WebController {

    private Scheduler scheduler;

    @Autowired
    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @GetMapping("/job-create")
    public String hello() throws SchedulerException {

        JobDetail jobDetail = JobBuilder.newJob(Quartz.class)
                .withIdentity("test", "test")
                .build();

//        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
//                .cronSchedule("*/3 * * * * ?")
//                .withMisfireHandlingInstructionDoNothing()
////                .withMisfireHandlingInstructionFireAndProceed()
////                .withMisfireHandlingInstructionIgnoreMisfires()
//                ;

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(3)
//                .withMisfireHandlingInstructionIgnoreMisfires()
//                .withMisfireHandlingInstructionNextWithExistingCount()
                .withMisfireHandlingInstructionNextWithRemainingCount()
//                .withMisfireHandlingInstructionFireNow()
                .repeatForever();

        final SimpleTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("test", "test")
                .withSchedule(scheduleBuilder)
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        return "success";
    }

    @GetMapping("/job-pause")
    public String pause() throws SchedulerException {

        scheduler.pauseJob(JobKey.jobKey("test", "test"));
        return "success";
    }

    @GetMapping("/job-resume")
    public String resume() throws SchedulerException {

        scheduler.resumeJob(JobKey.jobKey("test", "test"));
        return "success";
    }
}
