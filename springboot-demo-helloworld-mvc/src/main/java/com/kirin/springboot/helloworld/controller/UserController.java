package com.kirin.springboot.helloworld.controller;

import com.kirin.HelloFormatTemplate;
import com.kirin.springboot.helloworld.entity.User;
import com.kirin.springboot.helloworld.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kirin
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    private final HelloFormatTemplate helloFormatTemplate;

    public UserController(UserService userService, HelloFormatTemplate helloFormatTemplate) {
        this.userService = userService;
        this.helloFormatTemplate = helloFormatTemplate;
    }

    @GetMapping("/format")
    public String format() {
        User user = new User();
        user.setUserId(110);
        user.setUserName("Kirin");
        return helloFormatTemplate.doFormat(user);
    }

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
