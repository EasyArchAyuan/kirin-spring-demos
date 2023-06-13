package com.kirin.springframework.springmvc.dao;

import org.springframework.stereotype.Repository;
import com.kirin.springframework.springmvc.entity.User;

import java.util.Collections;
import java.util.List;

/**
 * @author kirin
 */
@Repository
public class UserDaoImpl {

    /**
     * mocked to find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return Collections.singletonList(new User("kirin", 18));
    }
}
