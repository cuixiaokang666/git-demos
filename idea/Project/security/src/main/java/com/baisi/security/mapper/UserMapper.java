package com.baisi.security.mapper;
import com.baisi.security.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层接口
 */
@Repository
@Mapper
public interface UserMapper{
    //查询所有用户
    public List<User> getAll();
    //查询用户
    public User getById(Integer id);
    //修改用户
    public Integer update(User user);
    //添加用户
    public Integer add(User user);
    //删除用户
    public Integer remove(Integer id);

    List<Integer> getByIds(Integer userId);

}
