package com.kirin.springframework.dao;

import java.util.Collections;
import java.util.List;

import com.kirin.springframework.entity.User;
import org.springframework.stereotype.Repository;

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
