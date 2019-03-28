package com.tao.spring.job;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Configuration;

/**
 * @author DongTao
 * @since 2019-03-25
 */
@Slf4j
@Configuration
public class Quartz implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("----------" + LocalDateTime.now());
    }
}
