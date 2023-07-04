package com.kirin.springboot.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Student {

    private String name;

    private Integer age;

    public void init() throws InterruptedException {
        log.info("student start Thread.currentThread.getName() = {}", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("student end Thread.currentThread.getName() = {}", Thread.currentThread().getName());
    }
}
