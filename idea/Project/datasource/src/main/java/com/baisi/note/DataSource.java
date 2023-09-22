package com.baisi.note;

import com.baisi.meiju.DataSourceKeys;

import java.lang.annotation.*;

//元数据
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    //定义属性
    DataSourceKeys value();
}
