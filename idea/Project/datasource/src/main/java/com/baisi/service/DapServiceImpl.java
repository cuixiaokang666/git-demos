package com.baisi.service;

import com.baisi.Mapper.DapMapper;
import com.baisi.entity.Dap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DapServiceImpl implements DapService{

    @Autowired
    private DapMapper mapper;

    @Override
    public List<Dap> selectAll() {
        return mapper.selectAll();
    }
}
