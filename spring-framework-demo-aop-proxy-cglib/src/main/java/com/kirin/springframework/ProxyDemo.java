package com.kirin.springframework;

import com.kirin.springframework.proxy.UserLogProxy;
import com.kirin.springframework.service.UserServiceImpl;

/**
 * Cglib proxy demo.
 *
 * @author kirin
 */
public class ProxyDemo {

    /**
     * main interface.
     *
     * @param args args
     */
    public static void main(String[] args) {
        // proxy
        UserServiceImpl userService = (UserServiceImpl) new UserLogProxy().getUserLogProxy(new UserServiceImpl());

        // call methods
        userService.findUserList();
        userService.addUser();
    }
}
