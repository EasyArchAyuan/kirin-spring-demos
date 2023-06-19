package com.kirin.springframework.staticproxy;

/**
 * @author Ayuan
 * @Description: TODO
 * @date 2023/6/19 16:10
 */
public class User implements UserInterface {

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
