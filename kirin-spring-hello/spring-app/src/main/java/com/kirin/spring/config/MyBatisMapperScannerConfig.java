package com.kirin.spring.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 扫描mybatis的接口，将mapper注册bean
 */
@Configuration
@AutoConfigureAfter(MybatisDiyConfig.class)
public class MyBatisMapperScannerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 获取之前注入的beanName为sqlSessionFactory的对象
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("diySqlSessionFactory");
        // 指定xml配置文件的路径
        mapperScannerConfigurer.setBasePackage("com.kirin.spring.test.mapper");
        return mapperScannerConfigurer;
    }

}