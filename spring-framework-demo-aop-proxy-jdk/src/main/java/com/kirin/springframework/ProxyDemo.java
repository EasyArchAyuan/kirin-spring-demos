package com.kirin.springframework;

import com.kirin.springframework.proxy.UserLogProxy;
import com.kirin.springframework.service.IUserService;
import com.kirin.springframework.service.UserServiceImpl;

/**
 * Jdk proxy demo.
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
        // generate proxy file, under 'com/sun/proxy'
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // proxy
        IUserService userService = new UserLogProxy(new UserServiceImpl()).getLoggingProxy();

        // call methods
        userService.findUserList();
        userService.addUser();
    }
}
