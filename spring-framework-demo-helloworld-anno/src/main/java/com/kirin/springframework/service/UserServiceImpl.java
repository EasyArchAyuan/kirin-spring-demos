package com.kirin.springframework.service;


import com.kirin.springframework.dao.UserDaoImpl;
import com.kirin.springframework.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kirin
 */
@Component
@RequiredArgsConstructor
public class UserServiceImpl {

    /**
     * user dao impl.
     */

    final UserDaoImpl userDao;

    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return userDao.findUserList();
    }

}
