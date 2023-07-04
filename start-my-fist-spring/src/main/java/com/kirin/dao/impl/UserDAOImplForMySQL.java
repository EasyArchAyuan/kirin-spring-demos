package com.kirin.dao.impl;

import com.kirin.dao.UserDAO;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/7/4 15:47
 */
public class UserDAOImplForMySQL implements UserDAO {

    @Override
    public void deleteById() {
        System.out.println("mysql删除用户信息");
    }

    @Override
    public void saveUserById() {
        System.out.println("mysql保存用户信息");

    }
}
