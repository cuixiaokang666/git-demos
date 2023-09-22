package com.baisi.service;

import com.baisi.Mapper.UsersMapper;
import com.baisi.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper mapper;

    @Override
    public List<Users> selectAll() {
        return mapper.selectAll();
    }
}
