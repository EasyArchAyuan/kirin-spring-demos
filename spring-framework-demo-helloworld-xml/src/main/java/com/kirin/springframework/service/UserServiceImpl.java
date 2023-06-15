package com.kirin.springframework.service;

import com.kirin.springframework.dao.UserDaoImpl;
import com.kirin.springframework.entity.User;

import java.util.List;


public class UserServiceImpl {

    public UserServiceImpl() {
    }

    private UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }


    /**
     * find user list.
     *
     * @return user list
     */
    public List<User> findUserList() {
        //执行方法日志
//        System.out.println("execute method: findUserList");
        return this.userDao.findUserList();
    }

    public String getUserName() {
//        System.out.println("execute method: getUserName");
        List<User> userList = this.userDao.findUserList();
        return userList.get(0).getName();
    }

}
