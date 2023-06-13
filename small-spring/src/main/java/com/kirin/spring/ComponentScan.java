package com.kirin.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Ayuan
 * @Description: 指定扫描路径
 * @date 2023/5/8 15:04
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //只能写在类上
public @interface ComponentScan {
    String value() default "";
}
