package com.kirin.springframework;

import com.kirin.springframework.service.UserServiceImpl;

/**
 * @author Ayuan
 * @Description: 不推荐setter注入
 * @date 2023/6/15 18:16
 */
public class SetterTest {
   // 不推荐setter注入

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        // -> NullPointerException, 潜在的隐患
        userService.findUserList();
    }


}
