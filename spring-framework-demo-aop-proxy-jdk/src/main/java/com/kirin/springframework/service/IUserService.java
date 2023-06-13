package com.kirin.springframework.service;

import com.kirin.springframework.entity.User;

import java.util.List;

/**
 * @author kirin
 */
public interface IUserService {

    /**
     * find user list.
     *
     * @return user list
     */
    List<User> findUserList();

    /**
     * add user
     */
    void addUser();
}
