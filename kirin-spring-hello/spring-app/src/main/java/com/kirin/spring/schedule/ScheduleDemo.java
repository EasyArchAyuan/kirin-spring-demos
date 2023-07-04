package com.kirin.spring.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@EnableScheduling
@Configuration
@Slf4j
public class ScheduleDemo {

    /**
     * 每隔1分钟执行一次。
     */
    @Scheduled(fixedRate = 1000 * 60)
    public void runScheduleFixedRate() {
        log.info("runScheduleFixedRate: current DateTime, {}", LocalDateTime.now());
    }

    /**
     * 每个整点小时执行一次。
     */
    @Scheduled(cron = "0 0 */1 * * ?")
    public void runScheduleCron() {
        log.info("runScheduleCron: current DateTime, {}", LocalDateTime.now());
    }

}