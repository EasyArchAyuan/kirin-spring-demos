package com.kirin.springframework;

import java.util.List;

import com.kirin.springframework.entity.User;
import com.kirin.springframework.config.BeansConfig;
import com.kirin.springframework.service.UserServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        UserServiceImpl service = context.getBean("userService", UserServiceImpl.class);

        List<User> userList = service.findUserList();

        userList.forEach(a -> System.out.println(a.getName() + "," + a.getAge()));
    }
}
