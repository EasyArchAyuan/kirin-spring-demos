package com.kirin.dao.impl;

import com.kirin.dao.UserDAO;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/7/4 15:55
 */
public class UserDAOImplForOracle implements UserDAO {

    @Override
    public void deleteById() {
        System.out.println("oracle删除用户信息");
    }

    @Override
    public void saveUserById() {
        System.out.println("oracle保存用户信息");
    }
}
