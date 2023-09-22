package com.baisi.security.service;
import com.baisi.security.entity.Role;
import org.springframework.stereotype.Service;
import java.util.List;
/*
    业务层
 */

@Service
public interface RoleService {
    //添加角色
    public List<Integer> getByIds(Integer id);
    //全表
    public List<Role> getAll();
}
