package com.kirin.springframework;

import java.util.List;

import com.kirin.springframework.config.BeansConfig;
import com.kirin.springframework.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.kirin.springframework.entity.User;

/**
 * @author kirin
 */
public class App {

    /**
     * main interfaces.
     *
     * @param args args
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        UserServiceImpl service = context.getBean(UserServiceImpl.class);
        System.out.println(service);
        UserServiceImpl service2 = context.getBean(UserServiceImpl.class);
        System.out.println(service2);
        List<User> userList = service.findUserList();
        userList.forEach(a -> System.out.println(a.getName() + "," + a.getAge()));
    }
}
