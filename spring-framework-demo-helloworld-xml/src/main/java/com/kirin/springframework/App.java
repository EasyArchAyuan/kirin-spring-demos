package com.kirin.springframework;

import java.util.List;

import com.kirin.springframework.dao.UserDaoImpl;
import com.kirin.springframework.entity.User;
import com.kirin.springframework.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        //传统开发:
//        UserDaoImpl userDao = new UserDaoImpl();
//        UserServiceImpl service = new UserServiceImpl();
//        service.setUserDao(userDao);

        //IOC开发：
        ApplicationContext context = new ClassPathXmlApplicationContext("aspects.xml", "services.xml");
        UserServiceImpl service = context.getBean("userService", UserServiceImpl.class);


        List<User> userList = service.findUserList();
        userList.forEach(a -> System.out.println(a.getName() + "," + a.getAge()));


        String userName = service.getUserName();
        System.out.println(userName);
    }
}
