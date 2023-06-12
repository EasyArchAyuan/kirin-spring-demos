package com.kirin.springframework;

import java.util.List;

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
        // create and configure beans
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                "com.kirin.springframework");

        // retrieve configured instance
        UserServiceImpl service = context.getBean(UserServiceImpl.class);

        // use configured instance
        List<User> userList = service.findUserList();

        // print info from beans
        userList.forEach(a -> System.out.println(a.getName() + "," + a.getAge()));
    }
}
