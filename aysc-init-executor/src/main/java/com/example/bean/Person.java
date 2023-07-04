package com.example.bean;

import com.example.spring.AsyncTaskExecutionListener;
import com.example.spring.AsyncTaskExecutor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j
public class Person {

    private String name;

    private Integer age;

    public void init() {
        AsyncTaskExecutor.submitTask(()->{
            log.info("person start Thread.currentThread.getName() = {}", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("person end Thread.currentThread.getName() = {}", Thread.currentThread().getName());
        });
    }
}
