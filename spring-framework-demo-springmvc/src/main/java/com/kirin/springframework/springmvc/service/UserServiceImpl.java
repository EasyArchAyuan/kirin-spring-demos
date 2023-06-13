package com.kirin.springframework.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kirin.springframework.springmvc.dao.UserDaoImpl;
import com.kirin.springframework.springmvc.entity.User;

import java.util.List;

/**
 * @author kirin
 */
@Service
public class UserServiceImpl {

    /**
     * user dao impl.
     */
    @Autowired
    private UserDaoImpl userDao;

    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return userDao.findUserList();
    }

}
