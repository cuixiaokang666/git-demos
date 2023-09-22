package com.baisi.staff.service;

import com.baisi.staff.entity.User;
import com.baisi.staff.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houyuanbo
 * on 2019/12/9 14:23
 *
 * @Description ：
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> findByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    public List<User> ListUser() {
        return userMapper.ListUser();
    }

    public List<User> queryPage(Integer starRows) {
        return userMapper.queryPage(starRows);
    }

    public int getRowCount() {
        return userMapper.getRowCount();
    }

    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    public int delete(int userId) {
        return userMapper.delete(userId);
    }

    public int Update(User user) {
        return userMapper.Update(user);
    }


}