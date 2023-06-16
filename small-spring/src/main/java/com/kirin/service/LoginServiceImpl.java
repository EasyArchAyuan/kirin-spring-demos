package com.kirin.service;

import com.kirin.spring.Autowired;
import com.kirin.spring.BeanNameAware;
import com.kirin.spring.Component;
import com.kirin.spring.InitializingBean;

/**
 * @author Ayuan
 * @Description: 登录测试
 * @date 2023/5/8 17:59
 */
@Component("loginService")
public class LoginServiceImpl implements BeanNameAware, InitializingBean, LoginService {

    @Autowired
    private UserService userService;

    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println("BeanNameAware");
    }

    @Override
    public void afterPropertiesSet() {
        // ....
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void test() {
        String name = userService.getName();
        System.out.println(name + "test");
    }
}
