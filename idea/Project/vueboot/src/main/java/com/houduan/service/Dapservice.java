package com.houduan.service;

import com.houduan.entity.Dap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Dapservice {
    public List<Dap> selectAll();
}
