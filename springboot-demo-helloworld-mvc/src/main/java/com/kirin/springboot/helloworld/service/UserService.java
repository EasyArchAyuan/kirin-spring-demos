package com.kirin.springboot.helloworld.service;

import java.util.List;

import com.kirin.springboot.helloworld.entity.User;

/**
 * user service.
 *
 * @author kirin
 */
public interface UserService {

    /**
     * @param user user
     */
    void addUser(User user);

    /**
     * @return user list
     */
    List<User> list();

}
