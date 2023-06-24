package com.kirin.springframework.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.kirin.springframework.dao.UserDaoImpl;
import com.kirin.springframework.entity.User;

/**
 * @author kirin
 */
@Component
@RequiredArgsConstructor
public class UserServiceImpl {

    /**
     * user dao impl.
     */

    private final UserDaoImpl userDao;

    @Autowired
    private Environment environment;

    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        return userDao.findUserList();
    }

    public UserServiceImpl(){
        System.out.println("UserServiceImpl的构造方法打印environment="+environment);
    }
}
