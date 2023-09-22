package com.baisi.config;
import com.baisi.aop.DynamicDataSource;
import com.baisi.meiju.DataSourceKeys;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MultiDataSourceConfig {
    //托管到spring容器
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource master(){
        return DataSourceBuilder.create().build();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    @ConditionalOnProperty(prefix = "spring.datasource.slave",name = "enabled",havingValue = "true")
    public DataSource slave(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource setDynamicDataSource(){
        Map<Object,Object> map = new HashMap<>();
        map.put(DataSourceKeys.MASTER.name(),master());
        map.put(DataSourceKeys.SLAVE.name(),slave());
        return new DynamicDataSource(map,master());
    }
}
