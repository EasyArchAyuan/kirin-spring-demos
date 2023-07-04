package com.kirin.springboot.helloworld.entity;

import lombok.*;

/**
 * User entity.
 *
 * @author kirin
 */
@Getter
@Setter
@ToString
public class User {

    /**
     * user id
     */
    private int userId;
    /**
     * username.
     */
    private String userName;
}
