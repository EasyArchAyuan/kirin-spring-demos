package com.example;

import com.example.bean.Person;
import com.example.bean.Student;
import com.example.spring.AsyncTaskExecutionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AyscInitExecutorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyscInitExecutorApplication.class, args);
    }

    @Bean
    public AsyncTaskExecutionListener asyncTaskExecutionListener() {
        return new AsyncTaskExecutionListener();
    }


    @Bean(value = "person",initMethod = "init")
    public Person person(){
        return new Person();
    }

    @Bean(value = "student",initMethod = "init")
    public Student student(){
        return new Student();
    }

}
