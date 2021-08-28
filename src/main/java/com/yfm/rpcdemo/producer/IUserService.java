package com.yfm.rpcdemo.producer;

/**
 * @Author yangFangMin
 * @Date 2021/8/28
 * @Todo
 */
public interface IUserService {

    /**
     * 获得用户
     * @return
     */
    User getUserByName(String name);
}
