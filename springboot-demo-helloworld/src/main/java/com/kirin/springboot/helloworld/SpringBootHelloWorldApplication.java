package com.kirin.springboot.helloworld;

import com.alipay.sofa.runtime.api.annotation.SofaAsyncInit;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author kirin
 */
@SpringBootApplication
@RestController
@Slf4j
public class SpringBootHelloWorldApplication {


//    public static final Logger log = (Logger) LoggerFactory.getLogger(SpringBootHelloWorldApplication.class);


    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHelloWorldApplication.class, args);
    }

    /**
     * hello world.
     *
     * @return hello
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        log.info("messs");
        return new ResponseEntity<>("hello world", HttpStatus.OK);
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
