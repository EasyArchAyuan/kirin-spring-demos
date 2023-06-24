package com.kirin.springframework.config;

import com.kirin.springframework.service.InitServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean(initMethod = "initMethod")
    public InitServiceImpl initService(){
        return new InitServiceImpl();
    }


    public void getState(){


    }
}
