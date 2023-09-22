package com.baisi.Mapper;

import com.baisi.entity.Users;
import com.baisi.meiju.DataSourceKeys;
import com.baisi.note.DataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UsersMapper {
    @Select("select * from users")
    @DataSource(DataSourceKeys.SLAVE)
    public List<Users> selectAll();

}
