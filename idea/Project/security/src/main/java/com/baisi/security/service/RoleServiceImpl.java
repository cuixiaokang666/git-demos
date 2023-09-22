package com.baisi.security.service;

import com.baisi.security.entity.Role;
import com.baisi.security.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Integer> getByIds(Integer id) {
        return roleMapper.getByIds(id);
    }

    @Override
    public List<Role> getAll() {
       return roleMapper.getAll();
    }
}
