package com.houduan.mapper;

import com.houduan.entity.Dap;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface DapMapper{
    public List<Dap> selectAll();
}
