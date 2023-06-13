package com.kirin.springframework.service;

import com.kirin.springframework.entity.User;

import java.util.Collections;
import java.util.List;

/**
 * @author kirin
 */
public class UserServiceImpl implements IUserService {

    /**
     * find user list.
     *
     * @return user list
     */
    @Override
    public List<User> findUserList() {
        return Collections.singletonList(new User("kirin", 18));
    }

    /**
     * add user
     */
    @Override
    public void addUser() {
        // do something
    }

}
