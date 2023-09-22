package com.baisi.aop;

import com.baisi.handler.DynamicDataSourceHandler;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

public class DynamicDataSource extends AbstractRoutingDataSource {

    //构造方法
    public DynamicDataSource(Map<Object, Object> targetDataSources,Object defaultTargetDataSource){
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.afterPropertiesSet();
    }

    @Override
    //每次执行数据库操作时都会调用

    //指定当前数据源
    protected Object determineCurrentLookupKey() {

        //返回的是某一个数据源对象对应的key
        return DynamicDataSourceHandler.getData();
    }
}
