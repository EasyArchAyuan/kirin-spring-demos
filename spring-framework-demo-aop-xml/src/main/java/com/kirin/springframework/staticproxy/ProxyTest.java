package com.kirin.springframework.staticproxy;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/6/19 16:13
 */
public class ProxyTest {
    public static void main(String[] args) {
        User user = new User();
        UserProxy userProxy = new UserProxy(user);
        userProxy.sayHello("Kirin");
    }
}
