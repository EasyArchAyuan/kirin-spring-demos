package com.example.bean;

import com.example.spring.AsyncTaskExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Student {

    private String name;

    private Integer age;

    public void init() {
        AsyncTaskExecutor.submitTask(()-> {
            log.info("student start Thread.currentThread.getName() = {}", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("student end Thread.currentThread.getName() = {}", Thread.currentThread().getName());
        });
    }
}
