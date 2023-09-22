package com.baisi.security.service;
import com.baisi.security.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务层接口
 */
@Service
public interface UserService{
    //查询所有
    public List<User> getAll();
    //通过id查询
    public User getById(Integer id);
    //修改
    public Integer update(User user);
    //添加
    public Integer add(User user);
    //删除
    public Integer remove(Integer id);

    List<Integer> getByIds(Integer userId);
}
