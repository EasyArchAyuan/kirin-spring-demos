package com.kirin.springframework.service;

import java.util.Collections;
import java.util.List;

import com.kirin.springframework.entity.User;

/**
 * @author kirin
 */
public class UserServiceImpl {

    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("kirin", 18));
    }

    /**
     * add user
     */
    public void addUser() {
        // do something
    }

}
