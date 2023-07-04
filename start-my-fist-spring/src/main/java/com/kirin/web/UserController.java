package com.kirin.web;

import com.kirin.service.UserService;
import com.kirin.service.impl.UserServiceImpl;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/7/4 15:46
 */
public class UserController {

    private UserService userService = new UserServiceImpl();

    public void deleteRequest() {
        userService.deleteUser();
    }

}
