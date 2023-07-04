package com.kirin.spring.entitys;

/**
 * @author kirin
 * 自定义错误接口
 */
public interface AppError {

    /**
     * 获取代码
     *
     * @return String
     */
    String getErrorCode();

    /**
     * 获取详情
     *
     * @return String
     */
    String getErrorMessage();
}