package com.kirin.springframework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author kirin
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.kirin.springframework")
public class BeansConfig {

}
