package com.tao.spring.wrapper;

/**
 * api错误码接口
 *
 * @author XuYiCheng
 * @since 2019-09-19
 */
public interface IStatus {

    /**
     * 状态码
     *
     * @return 状态码
     */
    Integer getCode();

    /**
     * 返回信息
     *
     * @return 返回信息
     */
    String getMessage();

}