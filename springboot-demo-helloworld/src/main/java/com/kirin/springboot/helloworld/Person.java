package com.kirin.springboot.helloworld;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;


@Slf4j
public class Person {

    private String name;

    private Integer age;

    public void init() throws InterruptedException {
        log.info("person start Thread.currentThread.getName() = {}", Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(5);
        log.info("person end Thread.currentThread.getName() = {}", Thread.currentThread().getName());
    }
}
