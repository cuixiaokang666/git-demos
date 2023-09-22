package com.baisi.staff.mapper;

import com.baisi.staff.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by houyuanbo
 * on 2019/12/9 13:57
 *
 * @Description ：数据库接口mapper接口类
 */
@Mapper
public interface UserMapper {

    /**
     * 通过名字查找信息
     * @param userName
     * @return  相同名字的信息的集合
     */
    public List<User> findUserByName(String userName);

    /**
     * 查找所有的员工名字的信息
     * @return 所有的员工
     */
    public List<User> ListUser();

    /**
     * 分页查询员工信息
     * @param starRows
     * @return 每一页的员工信息的集合
     */
    public List<User> queryPage(Integer starRows);

    /**
     * 每一行的个数
     * @return
     */
    public int getRowCount();

    /**
     * 插入员工信息
     * @param user
     * @return 是否成功
     */
    public int insertUser(User user);

    /**
     * 通过id删除员工信息
     * @param userId
     * @return 是否成功
     */
    public int delete(int userId);

    /**
     * 更新员工信息
     * @param user
     * @return  是否成功
     */
    public int Update(User user);


}