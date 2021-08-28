package com.yfm.rpcdemo.producer.Imp;

import com.yfm.rpcdemo.producer.IUserService;
import com.yfm.rpcdemo.producer.User;

/**
 * @Author yangFangMin
 * @Date 2021/8/28
 * @Todo
 */
public class UserService implements IUserService {

    @Override
    public User getUserByName(String name) {
        if("1".equals(name)) {
            return new User("张三");
        }
        else if("2".equals(name)) {
            return new User("李四");
        }
        return null;
    }
}
