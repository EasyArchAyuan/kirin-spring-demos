package com.kirin.springframework.staticproxy;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/6/19 16:11
 */
public class UserProxy implements UserInterface {
    private UserInterface target;

    public UserProxy(UserInterface target) {
        this.target = target;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("before say hello");
        target.sayHello(name);
        System.out.println("after say hello");
    }
}
