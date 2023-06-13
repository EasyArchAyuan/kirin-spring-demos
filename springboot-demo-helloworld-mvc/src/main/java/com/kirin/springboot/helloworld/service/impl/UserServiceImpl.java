package com.kirin.springboot.helloworld.service.impl;

import java.util.List;

import com.kirin.springboot.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kirin.springboot.helloworld.dao.UserRepository;
import com.kirin.springboot.helloworld.entity.User;

/**
 * user service impl.
 *
 * @author kirin
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * user dao.
     */
    @Autowired
    private UserRepository userDao;

    /**
     * @param user user
     */
    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    /**
     * @return user list
     */
    @Override
    public List<User> list() {
        return userDao.findAll();
    }

}
