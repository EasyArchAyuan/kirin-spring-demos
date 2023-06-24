package com.kirin.springframework;

import com.kirin.springframework.proxy.UserLogProxy;
import com.kirin.springframework.service.UserServiceImpl;
import net.sf.cglib.core.DebuggingClassWriter;

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
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Applications/soft/spring-demos");

        // proxy
        UserServiceImpl userService = (UserServiceImpl) new UserLogProxy().getUserLogProxy(new UserServiceImpl());

        // call methods
        userService.findUserList();
        userService.addUser();
    }
}
