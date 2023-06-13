package com.kirin.springframework.config;

import com.kirin.springframework.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author kirin
 */
@Configuration
public class BeansConfig {

    @Bean(name = "user", initMethod = "doInit", destroyMethod = "doDestroy")
    public User create() {
        User user = new User();
        user.setName("kirin");
        user.setAge(18);
        return user;
    }
}
