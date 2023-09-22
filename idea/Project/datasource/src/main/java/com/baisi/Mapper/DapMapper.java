package com.baisi.Mapper;

import com.baisi.entity.Dap;
import com.baisi.meiju.DataSourceKeys;
import com.baisi.note.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
@DataSource(DataSourceKeys.MASTER)
public interface DapMapper {
    @Select("select * from dap")
    public List<Dap> selectAll();

    @Select("select * from dap where id = #{id}")
    public Dap selectId(int id);
}
