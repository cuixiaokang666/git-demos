package com.denglu.deng.dao;

import com.denglu.deng.model.User;

public interface UserMapper {
    //通过用户名查询用户
    User getByUsername(String username);
}
