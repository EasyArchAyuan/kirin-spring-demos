package com.kirin.spring;

import com.kirin.service.LoginService;

/**
 * @author Ayuan
 * @Description: 测试启动类
 * @date 2023/5/8 15:01
 */
public class SmallSpringApplication {

    public static void main(String[] args) {
        //spring容器自定义
        DiyApplicationContext diyApplicationContext = new DiyApplicationContext(AppConfig.class);
        //获取对象
        LoginService loginServiceImpl = (LoginService) diyApplicationContext.getBean("loginServiceImpl");
        //执行方法
        loginServiceImpl.test();
    }
}
