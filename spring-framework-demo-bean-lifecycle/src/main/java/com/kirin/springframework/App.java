package com.kirin.springframework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.kirin.springframework.entity.User;

/**
 * Cglib proxy demo.
 *
 * @author kirin
 */
@Slf4j
public class App {

    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        log.info("Init application context");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.kirin.springframework");

        User user = (User) context.getBean("user");

        log.info(user.toString());

        log.info("Shutdown application context");
        context.registerShutdownHook();
    }
}
