package com.denglu.deng.dao;

import com.denglu.deng.model.User;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层实现
 */
@Repository
public class UserMapperImpl implements UserMapper {
    //根据用户名查询用户
    @Override
    public User getByUsername(String username) {
        if("张三".equals(username)){
            return new User("张三", "123", "1");
        }
        return null;
    }
}
