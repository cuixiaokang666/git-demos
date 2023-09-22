package com.houduan.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.houduan.entity.Dap;
import com.houduan.mapper.DapMapper;
import java.util.List;

@Service
public class Dapserviceimpl implements Dapservice{
    @Autowired
    private DapMapper mapper;

    @Override
    public List<Dap> selectAll() {
        List<Dap> d =  mapper.selectAll();
        return d;
    }
}
