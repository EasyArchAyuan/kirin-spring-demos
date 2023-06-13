package com.kirin.springboot.helloworld.controller;

import java.util.List;

import com.kirin.springboot.helloworld.entity.User;
import com.kirin.springboot.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kirin
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * http://localhost:8080/user/add .
     *
     * @param user user param
     * @return user
     */
    @PostMapping("add")
    public User add(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    /**
     * http://localhost:8080/user/list .
     *
     * @return user list
     */
    @GetMapping("list")
    public List<User> list() {
        return userService.list();
    }
}
