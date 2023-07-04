package com.example.demo;

import com.example.demo.bean.Person;
import com.example.demo.bean.Student;
import com.example.demo.spring.SofaAsyncInit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean(value = "person",initMethod = "init")
    @SofaAsyncInit
    public Person person(){
        return new Person();
    }

    @Bean(value = "student",initMethod = "init")
    @SofaAsyncInit
    public Student student(){
        return new Student();
    }
}
