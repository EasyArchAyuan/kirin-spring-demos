package com.kirin.springframework.dao;
import com.kirin.springframework.entity.User;

import java.util.Collections;
import java.util.List;

/**
 * @author kirin
 */
public class UserDaoImpl {

    /**
     * init.
     */
    public UserDaoImpl() {
    }

    /**
     * mocked to find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("kirin", 18));
    }
}
