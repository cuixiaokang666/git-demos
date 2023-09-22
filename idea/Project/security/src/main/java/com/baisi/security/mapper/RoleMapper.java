package com.baisi.security.mapper;

import com.baisi.security.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 持久层
 */

@Repository
@Mapper
public interface RoleMapper {
    //添加角色
    @Select("select role_id from user_role where user_id = #{userId}")
    public List<Integer> getByIds(Integer id);
    //全表
    @Select("select * from role")
    public List<Role> getAll();
}
