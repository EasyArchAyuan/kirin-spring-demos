package com.kirin.service;

import com.kirin.spring.Component;
import com.kirin.spring.Scope;

/**
 * @author Ayuan
 * @Description: 测试service
 * @date 2023/5/8 15:01
 */
@Component("userService")
//@Scope("prototype")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Override
    public String getName() {
        return "name";
    }
}
