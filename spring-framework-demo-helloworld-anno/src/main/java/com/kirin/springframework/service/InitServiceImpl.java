package com.kirin.springframework.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitServiceImpl implements InitializingBean {
    @Autowired
    private Environment environment;

    public InitServiceImpl() {
        System.out.println("InitServiceImpl的构造方法打印environment=" + environment);
    }


    /**
     * InitializingBean接口中的方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitServiceImpl使用InitializingBean打印environment="+environment);
    }


    /**
     * 使用@Bean的init-method属性
     */
    public void initMethod() {
        System.out.println("InitServiceImpl使用initMethod打印environment="+environment);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("InitServiceImpl使用@postConstruct打印environment="+environment);
    }
}
