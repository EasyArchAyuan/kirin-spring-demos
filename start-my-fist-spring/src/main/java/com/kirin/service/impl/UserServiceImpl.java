package com.kirin.service.impl;

import com.kirin.dao.UserDAO;
import com.kirin.dao.impl.UserDAOImplForMySQL;
import com.kirin.service.UserService;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/7/4 15:47
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImplForMySQL();

    @Override
    public void deleteUser() {
        userDAO.deleteById();
        //其他业务代码....
    }

    @Override
    public void saveUser() {
        userDAO.saveUserById();
    }


}
